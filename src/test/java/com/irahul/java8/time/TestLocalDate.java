package com.irahul.java8.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

import org.junit.Assert;
import org.junit.Test;

/**
 * Local date - no time info available. This date is "local" and valid no matter where in the world
 * @author rahul
 *
 */
public class TestLocalDate {

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
}
