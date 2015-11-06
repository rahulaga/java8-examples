package com.irahul.java8.interfacedefault;

/**
 * Second version extending class
 * @author rahul
 *
 */
public class EnglishSpeaker2 extends EnglishGreeter implements Swear {

	@Override
	public String sayCurse() {		
		return "F2";
	}

	//forced to define due to diamond
	@Override
	public String sayHello() {
		return super.sayHello()+sayCurse();
	}

}
