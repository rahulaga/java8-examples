package com.irahul.java8.interfacedefault;

/**
 * Interface with new default
 * @author rahul
 *
 */
public interface Greeter {

	default String sayHello(){
		return "Hello";
	}
	
	String sayBye();
		
}
