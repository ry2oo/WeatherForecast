package weatherInfo.rawData.parameters;

// パス指定
// Current & Forecast
public class Path {

	String val = "weather?";
	public boolean flg = true;
	
	public Path(String val){
		this.val = val;
		if(val.equals("weather?")) {
			flg = true;
		}else if(val.equals("forecast?")){
			flg = false;
		}
	}

	public String getVal() {
		return val;
	}
}
