package com.irahul.java8.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Annotation applied to a type
 * @author rahul
 *
 */
@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TypeAnnotation {

}
