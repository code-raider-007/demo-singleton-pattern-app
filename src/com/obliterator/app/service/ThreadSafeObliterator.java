package com.obliterator.app.service;

import java.io.Serializable;

public class ThreadSafeObliterator implements Obliterator, Serializable {

	private static final long serialVersionUID = -3177856502377197643L;
	
	private static ThreadSafeObliterator INSTANCE;
	private static Object classLock = ThreadSafeObliterator.class;
	
	private ThreadSafeObliterator() {
		super();
	}
	
	/**
	 * Lazy instantiation of the ThreadSafeObliterator singleton
	 * @return
	 */
	public static ThreadSafeObliterator getNewObliterator() {
		
		if(INSTANCE == null) {
			synchronized (classLock) {
				if(INSTANCE == null) {
					INSTANCE = new ThreadSafeObliterator();
				}
			}
		}
		return INSTANCE;
	}

	@Override
	public void obliterate() {
		System.out.println(this.getClass().getName() + " obliterated...");
	}
	
	protected Object readResolve() {
		return INSTANCE;
	}
	
}
