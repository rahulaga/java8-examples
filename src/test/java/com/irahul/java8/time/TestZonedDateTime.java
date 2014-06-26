package com.irahul.java8.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRules;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * Date time with Time Zone info
 * @author rahul
 *
 */
public class TestZonedDateTime {
	
	@Test
	public void testZonesAndConversion(){
		Set<String> allZones = ZoneId.getAvailableZoneIds();
		Assert.assertTrue(allZones.contains("America/Los_Angeles"));
		
		ZoneId pacific = ZoneId.of("America/Los_Angeles");		
		LocalDateTime now = LocalDateTime.now();//no timezone info		
		ZonedDateTime pacificTime = now.atZone(pacific);//assign a zone to local time
		ZoneOffset pacificOffset = pacificTime.getOffset();//current offset (affected by daylight savings)		
		ZoneRules pacificRules = pacific.getRules();//contains rules around transitions 
		
		//don't want to write asserts as tests will break half the year :)
		System.out.println(pacificOffset);
		System.out.println(pacificRules.getTransitionRules());
		
		
		ZoneId singapore = ZoneId.of("Singapore");		
		ZonedDateTime singaporeTime = pacificTime.withZoneSameInstant(singapore);//convert 
		ZoneOffset singaporeOffset = singaporeTime.getOffset();
		System.out.println(singaporeOffset);				
		System.out.println("PST="+pacificTime+" SG="+singaporeTime);
		
		
		int offsetPacific = pacificOffset.getTotalSeconds();
		int offsetSg = singaporeOffset.getTotalSeconds();
		//total difference
		int secondsOffset = offsetSg-offsetPacific;
		ZoneOffset offsetDiff = ZoneOffset.ofTotalSeconds(secondsOffset);
		System.out.println(offsetDiff);
		
		//moving between timezones in a different way
		LocalDateTime timeAdd = pacificTime.toLocalDateTime().plusSeconds(secondsOffset);
		Assert.assertEquals(timeAdd, singaporeTime.toLocalDateTime());//compare without tz
		Assert.assertEquals(singaporeTime, timeAdd.atZone(singapore));//with tz				
	}
}
