package com.obliterator.app.service;

public class ObliteratorImpl implements Obliterator {
	
	private static final ObliteratorImpl INSTANCE = new ObliteratorImpl();

	private ObliteratorImpl() {
	}
	
	public static ObliteratorImpl getNewObliterator() {
		return INSTANCE;
	}

	@Override
	public void obliterate() {
		System.out.println(this.getClass().getName() + " obliterated...");
	}

}
