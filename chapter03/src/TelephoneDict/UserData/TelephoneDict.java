package TelephoneDict.UserData;

public class TelephoneDict {
	private static int uniqueCode = 0;
	private String storeName;
	private String storetelNumber;
	
	public TelephoneDict(String storeName, String storetelNumber) {
		super();
		this.storeName = storeName;
		this.storetelNumber = storetelNumber;
		uniqueCode++;
	}

	@Override
	public String toString() {
		return "TelephoneDict [storeName=" + storeName + ", storetelNumber=" + storetelNumber + "]";
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoretelNumber() {
		return storetelNumber;
	}

	public void setStoretelNumber(String storetelNumber) {
		this.storetelNumber = storetelNumber;
	}
	
	
	
	
	

}
