package com.home.education.concurrent;

public class Printer {

	private String message;

	public Printer(String msg) {
		this.message = msg;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void print(){	
		System.out.println(Thread.currentThread().getName() + " " + message);
	}
}
