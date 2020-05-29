package fr.peaceandcube.pacpi.date;

public enum LocalizedMonth {
	JANUARY(1, "janvier", 31),
	FEBRUARY(2, "f�vrier", 29),
	MARCH(3, "mars", 31),
	APRIL(4, "avril", 30),
	MAY(5, "mai", 31),
	JUNE(6, "juin", 30),
	JULY(7, "juillet", 31),
	AUGUST(8, "ao�t", 31),
	SEPTEMBER(9, "septembre", 30),
	OCTOBER(10, "octobre", 31),
	NOVEMBER(11, "novembre", 30),
	DECEMBER(12, "d�cembre", 31);
	
	private int number;
	private String localizedName;
	private int maxDays;
	
	private LocalizedMonth(int number, String localizedName, int maxDays) {
		this.number = number;
		this.localizedName = localizedName;
		this.maxDays = maxDays;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String getLocalizedName() {
		return this.localizedName;
	}
	
	public int getMaxDays() {
		return this.maxDays;
	}
	
	public static LocalizedMonth fromNumber(int number) {
		for (LocalizedMonth month : LocalizedMonth.values()) {
			if (month.getNumber() == number) {
				return month;
			}
		}
		return null;
	}
	
	public static LocalizedMonth fromString(String localizedName) {
		for (LocalizedMonth month : LocalizedMonth.values()) {
			if (month.getLocalizedName().equals(localizedName)) {
				return month;
			}
		}
		return null;
	}
}
