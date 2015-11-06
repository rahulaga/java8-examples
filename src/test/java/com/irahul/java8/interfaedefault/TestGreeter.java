package com.irahul.java8.interfaedefault;

import org.junit.Assert;
import org.junit.Test;

import com.irahul.java8.interfacedefault.EnglishGreeter;
import com.irahul.java8.interfacedefault.EnglishSpeaker1;
import com.irahul.java8.interfacedefault.EnglishSpeaker2;
import com.irahul.java8.interfacedefault.Greeter;
import com.irahul.java8.interfacedefault.HawaiianGreeter;


public class TestGreeter {

	@Test
	public void testDefaults(){
		Greeter englishGreeter = new EnglishGreeter();
		Assert.assertEquals("Hello", englishGreeter.sayHello());
		Assert.assertEquals("Bye", englishGreeter.sayBye());
		
		Greeter hawaiiGreeter = new HawaiianGreeter();
		Assert.assertEquals("Aloha", hawaiiGreeter.sayHello());
		Assert.assertEquals("Aloha", hawaiiGreeter.sayBye());
	}
	
	@Test
	public void testSpeaker1(){
		EnglishSpeaker1 speaker = new EnglishSpeaker1();
		Assert.assertEquals("HelloF1", speaker.sayHello());
		Assert.assertEquals("ByeF1", speaker.sayBye());
		Assert.assertEquals("F1", speaker.sayCurse());
	}
	

	@Test
	public void testSpeaker2(){
		EnglishSpeaker2 speaker = new EnglishSpeaker2();
		Assert.assertEquals("HelloF2", speaker.sayHello());
		Assert.assertEquals("Bye", speaker.sayBye());
		Assert.assertEquals("F2", speaker.sayCurse());
	}
}
