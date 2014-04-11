package com.irahul.java8.time;

import java.time.Duration;
import java.time.Period;

import org.junit.Assert;
import org.junit.Test;

/**
 * Duration and Period are similar
 * Duration applies to time only (mins, seconds) so you can there is no ambiguitby when you add/subtract
 * Period applies to date (years, months, days) - a P1Y could be 365 or 366 so you cannot 
 * find the days in a period 1 year.
 * 
 * @author rahula238
 *
 */
public class TestDurationPeriod {

	@Test
	public void testDuration(){
		Duration oneDay = Duration.ofDays(1);
		long mins = oneDay.toMinutes();
		long secs = oneDay.getSeconds();//not sure why this is not toSeconds()
		
		Assert.assertEquals(mins, 24*60);
		Assert.assertEquals(secs, 24*60*60);
		
		Duration twentyFiveHours = Duration.ofHours(25);
		
		//days are represented in hours
		Duration oneDayTwentyFiveHours = oneDay.plus(twentyFiveHours);
		Assert.assertEquals(2, oneDayTwentyFiveHours.toDays());
		Assert.assertEquals(49, oneDayTwentyFiveHours.toHours());
		Assert.assertEquals("PT49H", oneDayTwentyFiveHours.toString());
		
		//adding 70 mins add 1hr and 10 mins
		Duration hourMin = twentyFiveHours.plusMinutes(70);
		Assert.assertEquals(1, hourMin.toDays());
		Assert.assertEquals(26, hourMin.toHours());
		Assert.assertEquals(26*60+10, hourMin.toMinutes());		
	}
	
	@Test
	public void testPeriod(){
		Period oneYear = Period.ofYears(1);
		long months = oneYear.getMonths();
		
		//this is a period P1Y - a period of 1Y does not have any months
		Assert.assertEquals(0, months);
		Assert.assertEquals(1, oneYear.getYears());
		
		Period oneYearOneMonth = oneYear.plusMonths(1);
		long months1 = oneYearOneMonth.getMonths();
		Assert.assertEquals(1, months1);
		
		//adding more than 12 months does not change the period in question
		Period oneYearTwentyMonths = oneYear.plusMonths(20);
		Assert.assertEquals(1, oneYearTwentyMonths.getYears());
		Assert.assertEquals(20, oneYearTwentyMonths.getMonths());
		
		//converting to months
		Assert.assertEquals(32, oneYearTwentyMonths.toTotalMonths());
		
		Assert.assertEquals("P1Y20M", oneYearTwentyMonths.toString());		
	}
}
