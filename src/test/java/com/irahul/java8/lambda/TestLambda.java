package com.irahul.java8.lambda;

import java.util.function.Predicate;

import org.junit.Assert;
import org.junit.Test;

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
}
