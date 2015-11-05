package com.irahul.java8.lambda;

import java.util.Arrays;

import org.junit.Test;

/**
 * Using :: for method reference
 * @author rahul
 *
 */
public class TestMethodReference {

	@Test
	public void testMethodReference(){
		 Arrays.asList(1, 2, 3, 4).forEach(value -> System.out.print(value+","));
		 Arrays.asList(1, 2, 3, 4).forEach(System.out::print);
	}
		
}
