package com.irahul.java8.annotation;

import org.junit.Assert;
import org.junit.Test;


/**
 * Applying annotation on types
 * @author rahul
 *
 */
public class TestAnnotation {

	@TypeAnnotation
	private String name="foo";
	
	@Test
	@RepeatedAnnotation("foo")
	@RepeatedAnnotation("bar")
	public void test(){
		Assert.assertNotNull(name);
	}
}
