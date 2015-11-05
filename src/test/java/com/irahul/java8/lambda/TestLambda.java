package com.irahul.java8.lambda;

import java.util.function.Predicate;

import org.junit.Assert;
import org.junit.Test;

/**
 * Using classes that are FunctionalInterface
 * 
 * @author rahul
 *
 */
public class TestLambda {

	@Test
	public void testPredicate(){
		//named
		Predicate<Integer> isEven = n -> n%2 == 0;
		
		Assert.assertTrue(isEven.test(2));
		Assert.assertFalse(isEven.test(1));
		
		predicateMethodCall(isEven);
		
		//anonymous
		predicateMethodCall(n -> n%2 == 0);
	}

	private void predicateMethodCall(Predicate<Integer> param) {
		Assert.assertTrue(param.test(2));
		Assert.assertFalse(param.test(1));		
	}
	
	@Test
	public void testRunnable(){
		//named runner
		Runnable runner = () -> System.out.println("Hello Named World!");
		new Thread(runner).start();
		
		//anonymous
		new Thread(() -> System.out.println("Hello Anonymous World!")).start();
	}
}
