package com.ubs.opsit.interviews.model;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.opsit.interviews.model.BerlinClock;

public class BerlinClockTest {

	BerlinClock berlinClock = new BerlinClock();

    // For Seconds
    @Test
    public void testForSeconds() {
        Assert.assertEquals("Y", berlinClock.getSeconds(0));
        Assert.assertEquals("O", berlinClock.getSeconds(1));
        Assert.assertEquals("O", berlinClock.getSeconds(59));
    }

    // For Top hours -- 4 Red Lamps -- 5 hours each
    @Test
    public void testForTopHours() {
        Assert.assertEquals("OOOO", berlinClock.getTopHours(0));
        Assert.assertEquals("RROO", berlinClock.getTopHours(13));
        Assert.assertEquals("RRRR", berlinClock.getTopHours(23));
        Assert.assertEquals("RRRR", berlinClock.getTopHours(24));
    }

    // For Bottom hours -- 4 Red Lamps -- 1 hour each
    @Test
    public void testForBottomHours() {
    	Assert.assertEquals("OOOO", berlinClock.getBottomHours(0));
        Assert.assertEquals("RRRO", berlinClock.getBottomHours(13));
        Assert.assertEquals("RRRO", berlinClock.getBottomHours(23));
        Assert.assertEquals("RRRR", berlinClock.getBottomHours(24));
    }

    // For Top minutes -- 11 Lamps -- 5 minutes each

    // For Top minutes -- 11 Lamps -- 5 minutes each -- 3rd, 6th and 9th lamps in Red to indicate first quarter, half and last quarter
    @Test
    public void testForTopMinutesRedLamp() {
        String minutes32 = berlinClock.getTopMinutes(32);
        Assert.assertEquals("R", minutes32.substring(2, 3));
        Assert.assertEquals("R", minutes32.substring(5, 6));
        Assert.assertEquals("O", minutes32.substring(8, 9));
    }

    // For Top minutes -- 11 Lamps -- 5 minutes each -- Yellow Lamp -- Unless it's first quarter, half or last quarter
    @Test
    public void testForTopMinutesYellowLamp() {
        Assert.assertEquals("OOOOOOOOOOO", berlinClock.getTopMinutes(0));
        Assert.assertEquals("YYROOOOOOOO", berlinClock.getTopMinutes(17));
        Assert.assertEquals("YYRYYRYYRYY", berlinClock.getTopMinutes(59));
    }

    // For Bottom minutes -- 4 Lamps -- 1 minute each
    @Test
    public void testForBottomMinutes() {
        Assert.assertEquals("OOOO", berlinClock.getBottomMinutes(0));
        Assert.assertEquals("YYOO", berlinClock.getBottomMinutes(17));
        Assert.assertEquals("YYYY", berlinClock.getBottomMinutes(59));
    }
    
}