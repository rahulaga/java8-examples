package com.irahul.java8.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * repeated annotation
 * 
 * @author rahul
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = RepeatedValue.class)
@Documented
public @interface RepeatedAnnotation {
	String value();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface RepeatedValue {
	RepeatedAnnotation[] value();
}
