package com.swarup;

public class MyTestClass {
	public void welcome(){
		System.out.println("Hi welcome............");
	}
	@MyAnnotation(dependent="welcome")
	public void execute(){
		System.out.println("executing........................");
	}
}
