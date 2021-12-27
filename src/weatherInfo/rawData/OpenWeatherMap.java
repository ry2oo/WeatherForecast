package weatherInfo.rawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import weatherInfo.rawData.parameters.City;
import weatherInfo.rawData.parameters.Lang;
import weatherInfo.rawData.parameters.Path;
import weatherInfo.rawData.parameters.Units;

// api固有のパラメータ指定
// URLから情報取得(JSON)
public class OpenWeatherMap {
	
	private String rawData; // 天気元データ(JSON)
	
	private Path path;
	private Lang lang;
	private Units units;
	private City city;
	
	public void setPara() {
		// パラメータ設定入力
		path = Input.inputPath();
		lang = Input.inputLang();
		units = Input.inputUnits();
		city = Input.inputCity();
		
	}
	
	public String getReqUrl() {
		Parameter para = new Parameter(path,lang,units,city);
		return para.createUrl();
	}
	
	// URLから元データ取得(JSON)
	public void setRawData(String requestUrl) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(requestUrl);
			InputStream is = url.openConnection().getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String line;
			while(null != (line = reader.readLine())) {
				sb.append(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println(">City does not exist");
			System.exit(0);
		}
		this.rawData = sb.toString();
	}
	
	public String getRawData() {
		return this.rawData;
	}
	
	public Path getPath() {
		return this.path;
	}
}
