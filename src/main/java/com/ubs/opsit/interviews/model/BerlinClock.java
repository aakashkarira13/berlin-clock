package com.ubs.opsit.interviews.model;

public class BerlinClock {

	private static final String RED_LAMP = "R";
	private static final String YELLOW_LAMP = "Y";
	private static final String OFF = "O";

	public String getSeconds(int number) {
		if (number % 2 == 0) 
			return YELLOW_LAMP;
		return OFF;
	}

	public String getTopHours(int number) {
		return getOnOff(4, getTopNumberOfOnSigns(number),RED_LAMP);
	}

	public String getBottomHours(int number) {
		return getOnOff(4, number % 5,RED_LAMP);
	}

	public String getTopMinutes(int number) {
		return getOnOff(11, getTopNumberOfOnSigns(number), YELLOW_LAMP).replaceAll("YYY", "YYR");
	}

	public String getBottomMinutes(int number) {
		return getOnOff(4, number % 5, YELLOW_LAMP);
	}

	private String getOnOff(int lamps, int onSigns, String onSign) {
		String signOut = "";
		for (int i = 0; i < onSigns; i++) {
			signOut += onSign;
		}
		for (int i = 0; i < (lamps - onSigns); i++) {
			signOut += OFF;
		}
		return signOut;
	}

	private int getTopNumberOfOnSigns(int number) {
		return (number - (number % 5)) / 5;
	}

}
