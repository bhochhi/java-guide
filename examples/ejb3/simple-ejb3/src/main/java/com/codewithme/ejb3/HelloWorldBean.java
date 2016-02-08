package com.codewithme.ejb3;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldBean implements HelloWorld {

	public String sayHello() {
		return "Hello world!!!";
	}

}
