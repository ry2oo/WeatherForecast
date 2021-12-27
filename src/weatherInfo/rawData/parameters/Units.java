package weatherInfo.rawData.parameters;

public class Units {

	String val;
	String[] values = {"standard","metric","imperial"};
	
	public Units(String val){
		if(checkUnit(val)) {
			this.val = val;
		}else {
			System.out.println("UNITの設定でエラー");
			System.exit(0);
		}
	}
	
	private boolean checkUnit(String val) {
		for(String str:this.values) {
			if(val.equals(str)) {
				return true;
			}
		}
		return false;
	}

	public String getVal() {
		return val;
	}
}
