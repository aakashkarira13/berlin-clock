package com.ubs.opsit.interviews.impl;

import java.util.Arrays;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.model.BerlinClock;

public class BerlinClockImpl implements TimeConverter {

	private BerlinClock berlinClock = new BerlinClock();
	
	public String convertTime(String time) {

		int[] parts = Arrays.asList(time.split(":")).stream().mapToInt(Integer::parseInt).toArray();
		String allClockUnits[] = new String[]{
				berlinClock.getSeconds(parts[2]),
				berlinClock.getTopHours(parts[0]),
				berlinClock.getBottomHours(parts[0]),
				berlinClock.getTopMinutes(parts[1]),
				berlinClock.getBottomMinutes(parts[1])
		};     
		return processBerlinClockTime(allClockUnits);
	}

	String processBerlinClockTime(String[] allClockUnits)
	{
		StringBuilder sb = new StringBuilder();
		for(String clockTime : allClockUnits) {
			sb.append(clockTime).append("\r\n");
		}
		return sb.substring(0, sb.length()-2);	
	}
}