package weatherInfo;

import weatherInfo.rawData.OpenWeatherMap;

public class Weather {
	public static void main(String[] args) {
		
		// setPara getReqUrl getJSON
		OpenWeatherMap owm = new OpenWeatherMap();
		owm.setPara();
		String reqUrl = owm.getReqUrl();
		owm.setRawData(reqUrl);
		System.out.println(reqUrl);
		ParseData pd = new ParseData();		
		
		// 現在 or 予報
		if(owm.getPath().flg) {
			pd.parseCurrentData(owm.getRawData());
			display(pd);
		}else {
			for(int i=0;i<=30;i+=8) {
				pd.parseForecastData(owm.getRawData(),i);
				display(pd);
			}
		}
	}
	
	static void display(ParseData pd) {
		StringBuilder sb = new StringBuilder();
		sb.append("\nDate: ").append(pd.dt)
		.append("\nCity: ").append(pd.name)
		.append("\nWeather: ").append(pd.weather)
		.append("\nDescription: ").append(pd.description)
		.append("\nTemp: ").append(pd.temp).append("℃")
		.append("\nTemp(max): ").append(pd.tempMax).append("℃")
		.append("\nTemp(min): ").append(pd.tempMin).append("℃")
		.append("\nHumidity: ").append(pd.humidity).append("%")
		.append("\nPressure: ").append(pd.pressure).append("hpa")
		.append("\nWind: ").append(pd.speed).append("m");
		
		System.out.println(sb.toString());
	}
}
