package com.irahul.java8.time;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

import org.junit.Assert;
import org.junit.Test;

/**
 * These are "local" times with no timezone info
 * @author rahul
 *
 */
public class TestLocalDateTime {

	/**
	 * Local date - no time info available. This date is "local" and valid no matter where in the world
	 */
	@Test
	public void testLocalDate(){
		//today
		LocalDate today = LocalDate.now();
		
		int y1 = today.get(ChronoField.YEAR);
		int y2 = today.getYear();
		Assert.assertEquals(y1, y2);
		
		//create specific date
		LocalDate nextHoliday = LocalDate.of(2014, Month.JULY, 4);
		Assert.assertEquals(2014, nextHoliday.getYear());
		Assert.assertEquals(7, nextHoliday.getMonthValue());
		Assert.assertEquals(Month.JULY, nextHoliday.getMonth());
		Assert.assertEquals(4, nextHoliday.getDayOfMonth());
		
		Assert.assertFalse(nextHoliday.isLeapYear());
		
		//adjustments
		LocalDate earlier = nextHoliday.minusDays(5);
		Assert.assertEquals(6, earlier.getMonthValue());
		Assert.assertEquals(29, earlier.getDayOfMonth());
		
		LocalDate friday = earlier.with(DayOfWeek.FRIDAY);
		Assert.assertEquals(27, friday.getDayOfMonth());
		Assert.assertEquals(6, friday.getMonthValue());
		
		LocalDate first = friday.with(TemporalAdjusters.firstDayOfMonth());
		Assert.assertEquals(1, first.getDayOfMonth());
		Assert.assertEquals(6, first.getMonthValue());
		
		//find last monday in may (memorial day), last thu in nov (thanksgiving) etc
		LocalDate may2014 = LocalDate.of(2014, Month.MAY, 15);
		LocalDate memorialDay = may2014.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
		Assert.assertEquals(26, memorialDay.getDayOfMonth());
		Assert.assertEquals(5, memorialDay.getMonthValue());		
	}
	
	/**
	 * Only contains time info, no date or timezone. "Local" for any place in the world
	 */
	@Test
	public void testLocalTime(){
		LocalTime now = LocalTime.now();
		System.out.println(String.format("toString=%s", now.toString()));
		
		LocalTime midnight = LocalTime.of(0, 0);
		Assert.assertEquals(0, midnight.getHour());
		Assert.assertEquals(0, midnight.getMinute());
		
		LocalTime pm1 = LocalTime.of(13, 25, 59);
		Assert.assertEquals(13, pm1.getHour());
		Assert.assertEquals(25, pm1.getMinute());
		Assert.assertEquals(59, pm1.getSecond());
		
		try{
			LocalTime.of(25, 0);//allowed 0 to 23
			Assert.fail();
		}
		catch (DateTimeException e){
			//expected
		}				
	}
	
	/**
	 * Combines above info
	 */
	@Test
	public void testLocalDateTime(){
		LocalDateTime now = LocalDateTime.now();
		System.out.println(String.format("toString=%s", now.toString()));
	}
}
