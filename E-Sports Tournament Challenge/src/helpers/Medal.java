package helpers;

public enum Medal {

	GOLD("GOLD"),
	SILVER("SILVER"),
	BRONZE("BRONZE"),
	NONE("NONE");
	
	private String medalType;
	
	private Medal(String medalType) {
		this.medalType = medalType;
	}
	
	public String getMedalType() {
		return medalType;
	}
	
}
