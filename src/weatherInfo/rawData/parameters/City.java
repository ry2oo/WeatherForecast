package weatherInfo.rawData.parameters;

// 都市
public class City {
	
	String name; //都市名
	double lat,lon; //緯度,経度
	boolean flg;
	
	public City(String name){
		this.name = name;
		flg = true;
	}
	
	public City(double lat, double lon) {
		this.lat = lat;
		this.lon = lon;
		flg = false;
	}

	public boolean isFlg() {
		return flg;
	}

	public String getName() {
		return name;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

}
