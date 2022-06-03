package com.obliterator.app.service;

import java.io.Serializable;

public class NotThreadSafeObliterator implements Obliterator, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7669731328794029361L;
	
	private static NotThreadSafeObliterator INSTANCE;

	private NotThreadSafeObliterator() {
		
	}
	
	/**
	 * Lazy instantiation of the NotThreadSafeObliterator singleton
	 * @return
	 */
	public static NotThreadSafeObliterator getNewObliterator() {
		
		if(INSTANCE == null) {
			INSTANCE = new NotThreadSafeObliterator();
		}
		return INSTANCE;
	}
	
	@Override
	public void obliterate() {
		System.out.println(this.getClass().getName() + " obliterated...");
	}
}
