package com.irahul.java8.time;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

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

		Instant timestampInstant = Instant.ofEpochMilli(timestamp); 
		Assert.assertEquals(timestamp, timestampInstant.truncatedTo(ChronoUnit.MILLIS).toEpochMilli());
		
		//different ways to go into the future
		Instant future1 = instant.plusMillis(1000);
		Instant future2 = instant.plus(1000, ChronoUnit.MILLIS);
		//add Duration instead of Period as this example is dealing with time
		Instant future3 = instant.plus(Duration.ofMillis(1000));
		Instant future4 = instant.plus(Duration.of(1000, ChronoUnit.MILLIS));
		
		//all futures are the same!		
		Assert.assertEquals(future1, future2);
		Assert.assertEquals(future2, future3);
		Assert.assertEquals(future3, future4);
	}

}
