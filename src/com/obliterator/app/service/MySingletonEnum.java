package com.obliterator.app.service;

public enum MySingletonEnum {
	
	INSTANCE;
	
	public void obliterate() {
		System.out.println(this.getClass().getName() + " obliterated...");
	}
}
