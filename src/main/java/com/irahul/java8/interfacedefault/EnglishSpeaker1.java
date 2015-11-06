package com.irahul.java8.interfacedefault;

/**
 * First version implementing interfaces
 * @author rahul
 *
 */
public class EnglishSpeaker1 implements Greeter, Swear {

	@Override
	public String sayCurse() {
		return "F1";
	}

	@Override
	public String sayBye() {
		return "Bye" + sayCurse();
	}

	//forced to define as appears in both interfaces 
	@Override
	public String sayHello() {
		return Greeter.super.sayHello() + sayCurse();
	}

}
