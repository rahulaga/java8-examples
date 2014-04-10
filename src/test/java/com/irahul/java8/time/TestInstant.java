package com.irahul.java8.time;

import java.time.Instant;
import java.time.temporal.ChronoField;

import org.junit.Assert;
import org.junit.Test;

/**
 * Instant
 * @author rahul
 *
 */
public class TestInstant {
	
	@Test
	public void testInstant(){
		//millisec since epoch
		long timestamp = System.currentTimeMillis();
		
		//point in time - now!
		Instant instant = Instant.now();
		long secEpoch = instant.getEpochSecond();
		
		//missing milli so divide by 1000
		Assert.assertEquals(timestamp/1000, secEpoch);
		Assert.assertEquals(instant.getLong(ChronoField.INSTANT_SECONDS), secEpoch);			
	}

}
