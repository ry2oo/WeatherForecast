package weatherInfo.rawData;

import java.util.InputMismatchException;
import java.util.Scanner;

import weatherInfo.rawData.parameters.City;
import weatherInfo.rawData.parameters.Lang;
import weatherInfo.rawData.parameters.Path;
import weatherInfo.rawData.parameters.Units;

public class Input {
	static Scanner sc = new Scanner(System.in);
	
	private static Path path;
	private static Lang lang;
	private static Units units;
	private static City city;
	
	// パス入力　現在 or 予報
	public static Path inputPath() {
			int select = 0;
			try {
				System.out.println(">Weather 1.Current 2.Future");
					select = sc.nextInt();
			}catch (InputMismatchException e) {
				System.err.println(">Input Value Error");
				System.exit(0);
			}
		
		// 入力値チェック
		if(select == 1) {
			// 現在
			path = new Path("weather?");
		}else if(select == 2) {
			// 予報
			path = new Path("forecast?");
		}else {
			// 範囲外
			System.err.println(">Input Value Error");
			inputPath(); // 再入力
		}
		return path;
	}
	
	// 都市入力 都市名 or 緯度経度
	public static City inputCity() {
		int select = 0;
		try {
			System.out.println(">City 1.CityName 2.latitude, longitude");
				select = sc.nextInt();
		}catch (InputMismatchException e) {
			System.err.println(">Input Value Error");
			System.exit(0);
		}
		
		// 入力値チェック
		if(select == 1) {
			// 都市名
			System.out.println(">CityName");
				city = new City(sc.next());
		}else if(select == 2) {
			// 緯度経度
			System.out.println(">latitude");
				double lat = sc.nextDouble();
			System.out.println(">longitude");
				double lon = sc.nextDouble();
			city = new City(lat,lon);
		}else {
			// 範囲外
			System.err.println(">Input Value Error");
			inputCity(); // 再入力
		}
		
		return city;
	}
	
	// 言語 日本語固定
	public static Lang inputLang() {
		lang = new Lang("ja");
		return lang;
	}
	
	// 測定単位　摂氏固定
	public static Units inputUnits() {
		units = new Units("metric");
		return units;
	}
	
}
