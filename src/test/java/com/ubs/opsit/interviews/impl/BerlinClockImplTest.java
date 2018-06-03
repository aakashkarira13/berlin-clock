package com.ubs.opsit.interviews.impl;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.opsit.interviews.impl.BerlinClockImpl;



public class BerlinClockImplTest {
	
    BerlinClockImpl berlinClockImpl = new BerlinClockImpl();

    // Berlin Clock it should "result in correct seconds, hours and minutes" in {
    @Test
    public void testBerlinClockShouldResultCorrectSecondsHoursAndMinutes() {
        String berlinTime = berlinClockImpl.convertTime("16:37:16");
        String expected = "Y\r\nRRRO\r\nROOO\r\nYYRYYRYOOOO\r\nYYOO";
        Assert.assertEquals(expected,berlinTime);
    }
    
}