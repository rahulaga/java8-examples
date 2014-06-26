package com.irahul.java8.time;

import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Looking at sub parts of a local date
 * @author rahul
 *
 */
public class TestDateFragments {

	@Test
	public void testYearMonth(){
		YearMonth now = YearMonth.now();
		System.out.println(String.format("toString=%s", now.toString()));

		YearMonth dateNotLeap = YearMonth.of(2010, Month.FEBRUARY);
		Assert.assertEquals(2010, dateNotLeap.getYear());
		Assert.assertEquals(28, dateNotLeap.lengthOfMonth());
		Assert.assertEquals(365, dateNotLeap.lengthOfYear());
				

		YearMonth dateLeap = YearMonth.of(2012, Month.FEBRUARY);
		Assert.assertEquals(2012, dateLeap.getYear());
		Assert.assertEquals(29, dateLeap.lengthOfMonth());
		Assert.assertEquals(366, dateLeap.lengthOfYear());
	}
	
	@Test
	public void testMonthDay(){
		MonthDay now = MonthDay.now();
		System.out.println(String.format("toString=%s", now.toString()));
		
		MonthDay newYear = MonthDay.of(Month.JANUARY, 1);
		MonthDay christmas = MonthDay.of(Month.DECEMBER, 25);
		
		Assert.assertTrue(christmas.isAfter(newYear));
		Assert.assertEquals("--12-25", christmas.toString());
	}
	
	@Test
	public void testYear(){
		Year now = Year.now();
		System.out.println(String.format("toString=%s", now.toString()));
		
		Year y2014 = Year.of(2014);
		Assert.assertFalse(y2014.isLeap());
		Assert.assertEquals("2014", y2014.toString());
	}
}
