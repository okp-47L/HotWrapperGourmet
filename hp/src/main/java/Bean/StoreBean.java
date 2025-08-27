package Bean;

import java.sql.Time;

public class StoreBean {

	private int storeCode;

	private String storeName;

	private String storeExplain;

	private Time openTime;

	private Time closeTime;

	private String address;

	private String storeImage;

	private double storeGrade;

	private int regularHoliday;

	private String isdn;

	private int genre;
	
	public int getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(int storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreExplain() {
		return storeExplain;
	}

	public void setStoreExplain(String storeExplain) {
		this.storeExplain = storeExplain;
	}

	public Time getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Time openTime) {
		this.openTime = openTime;
	}

	public Time getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Time closeTime) {
		this.closeTime = closeTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStoreImage() {
		return storeImage;
	}

	public void setStoreImage(String storeImage) {
		this.storeImage = storeImage;
	}

	public double getStoreGrade() {
		return storeGrade;
	}

	public void setStoreGrade(double storeGrade) {
		this.storeGrade = storeGrade;
	}

	public int getRegularHoliday() {
		return regularHoliday;
	}

	public void setRegularHoliday(int regularHoliday) {
		this.regularHoliday = regularHoliday;
	}

	public String getIsdn() {
		return isdn;
	}

	public void setIsdn(String isdn) {
		this.isdn = isdn;
	}

	public int getGenre() {
		return genre;
	}

	public void setGenre(int genre) {
		this.genre = genre;
	}


}
