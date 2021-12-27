package weatherInfo.rawData;

import weatherInfo.rawData.parameters.City;
import weatherInfo.rawData.parameters.Lang;
import weatherInfo.rawData.parameters.Path;
import weatherInfo.rawData.parameters.Units;

public class Parameter {
	
	static final String BASE_URL = "http://api.openweathermap.org/data/2.5/"; // BaseURL
	private Path path; // 天気　現在 or 予報
	static final String KEY = "appid=bb77cd4c633f7eeaab9c42f6b18cc26e";
	private City city; // 都市
	private Lang lang; // 言語
	private Units units; // 測定単位
	
	
	StringBuilder sb = new StringBuilder();
	
	// パラメータの設定
	public Parameter(Path path,Lang lang,Units units,City city){
		this.path = path;
		this.city = city;
		this.lang = lang;
		this.units = units;
	}
	
	// リクエストURL作成
	public String createUrl() {
		sb.append(BASE_URL).append(path.getVal()).append(KEY)
		.append("&lang=").append(lang.getVal())
		.append("&units=").append(units.getVal());
		
		// 都市の指定 名前 or 緯度経度
		if(city.isFlg()) {
			sb.append("&q=").append(city.getName());
		}else {
			sb.append("&lat=").append(city.getLat())
			.append("&lon=").append(city.getLon());
		}
		
		return sb.toString();
	}


}
