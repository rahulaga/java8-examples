package com.irahul.java8.interfacedefault;

public class HawaiianGreeter implements Greeter {

	@Override
	public String sayHello() {
		return "Aloha";
	}

	@Override
	public String sayBye() {
		return sayHello();
	}
}
