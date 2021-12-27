package weatherInfo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseData {
	
	String weather; // 天気
	String description; // 詳細
	double temp; // 気温
	double tempMin; // 最低気温
	double tempMax; // 最高気温
	int humidity; // 湿度(%)
	int pressure; // 気圧(hpa)
	double speed; // 風速(m)
	String dt; // データ時間
	String name; // 都市名

	//JSON Obj
	void parseCurrentData(String weatherData) {
		JSONObject obj = new JSONObject(weatherData);
		
		JSONArray weatherArray = obj.getJSONArray("weather");
		JSONObject weathers = weatherArray.getJSONObject(0);
		weather = weathers.getString("main");
		description = weathers.getString("description");
		
		JSONObject temps = obj.getJSONObject("main");
		temp = temps.getDouble("temp");
		tempMin = temps.getDouble("temp_min");
		tempMax = temps.getDouble("temp_max");
		humidity = temps.getInt("humidity");
		pressure = temps.getInt("pressure");
		
		JSONObject wind = obj.getJSONObject("wind");
		speed = wind.getDouble("speed");
		
		dt = timeConv(obj.getInt("dt"));
		
		
		name = obj.getString("name");
	}
	
	void parseForecastData(String weatherData, int i) {
		JSONObject obj = new JSONObject(weatherData);
		
		JSONObject city = obj.getJSONObject("city");
		name = city.getString("name");
		
		JSONArray list = obj.getJSONArray("list");	
		
		JSONObject cnt = list.getJSONObject(i);
		dt = timeConv(cnt.getInt("dt"));
		
		JSONObject main = cnt.getJSONObject("main");
		temp = main.getDouble("temp");
		tempMin = main.getDouble("temp_min");
		tempMax = main.getDouble("temp_max");
		humidity = main.getInt("humidity");
		pressure = main.getInt("pressure");
		
		JSONArray weathreArray = cnt.getJSONArray("weather");
		JSONObject weathers = weathreArray.getJSONObject(0);
		weather = weathers.getString("main");
		description = weathers.getString("description");
		
		JSONObject wind = cnt.getJSONObject("wind");
		speed = wind.getDouble("speed");
		
	}
	
	private String timeConv(int dt) {
		Instant instant = Instant.ofEpochSecond(dt);
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		return localDateTime.format(dateFormat);
	}
}
