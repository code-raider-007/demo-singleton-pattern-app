package com.obliterator.app;

import com.obliterator.app.test.MySingletonTester;

public class ObliteratorMain {

	public static void main(String[] args) {
		MySingletonTester mySingletonTester = new MySingletonTester();
		mySingletonTester.simpleSingletonTest();
		mySingletonTester.reflectionTest();
		mySingletonTester.serializeDeserializeTest();
		mySingletonTester.serializeDeserializeEnumTest();
	}

}
