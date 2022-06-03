package com.obliterator.app.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

import com.obliterator.app.service.MySingletonEnum;
import com.obliterator.app.service.NotThreadSafeObliterator;
import com.obliterator.app.service.ThreadSafeObliterator;

public class MySingletonTester {
	
	private final String textFileName = "test.txt";
	private final String enumFileName = "enum.txt";
	
	public void simpleSingletonTest() {
		
		NotThreadSafeObliterator notThreadSafeObliterator1 = NotThreadSafeObliterator.getNewObliterator();
		NotThreadSafeObliterator notThreadSafeObliterator2 = NotThreadSafeObliterator.getNewObliterator();
		
		//Let's check to see if indeed we have the same object
		if(notThreadSafeObliterator1 == notThreadSafeObliterator2) {
			System.out.println("notThreadSafeObliterator1 and notThreadSafeObliterator2 are indeed the same object");
			System.out.println("singleton pattern is in force");
			System.out.println();
		} else {
			System.out.println("notThreadSafeObliterator1 and notThreadSafeObliterator2 are not the same object");
			System.out.println("singleton pattern has been violated");
			System.out.println();
		}
	}

	public void reflectionTest() {
		ThreadSafeObliterator threadSafeObliterator = ThreadSafeObliterator.getNewObliterator();
		
		try {
			Constructor<ThreadSafeObliterator> constructor = ThreadSafeObliterator.class.getDeclaredConstructor(new Class[]{});
			constructor.setAccessible(true);
			ThreadSafeObliterator threadSafeObliterator2 = constructor.newInstance();
			
			if(threadSafeObliterator == threadSafeObliterator2) {
				System.out.println("Both threadSafeObliterator and threadSafeObliterator2 represent the same object");
				System.out.println("threadSafeObliterator hashcode : " + threadSafeObliterator.hashCode());
				System.out.println("threadSafeObliterator2 hashcode : " + threadSafeObliterator2.hashCode());
				System.out.println();
			} else {
				System.out.println("threadSafeObliterator and threadSafeObliterator2 do not represent the same object.");
				System.out.println("threadSafeObliterator hashcode : " + threadSafeObliterator.hashCode());
				System.out.println("threadSafeObliterator2 hashcode : " + threadSafeObliterator2.hashCode());
				System.out.println("The singleton pattern has been violated");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void serializeDeserializeTest() {
		
		try {
			File file = new File(textFileName);
			ThreadSafeObliterator threadSafeObliterator = ThreadSafeObliterator.getNewObliterator();
			
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(threadSafeObliterator);
			
			objectOutputStream.close();
			
			
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			ThreadSafeObliterator threadSafeObliterator2 = (ThreadSafeObliterator)objectInputStream.readObject();
			
			if(file.exists()) {
				file.deleteOnExit();
			}
			objectInputStream.close();
			
			
			if(threadSafeObliterator == threadSafeObliterator2) {
				System.out.println("(serializeDeserializeTest) Both threadSafeObliterator and threadSafeObliterator2 represent the same object");
				System.out.println("threadSafeObliterator hashcode : " + threadSafeObliterator.hashCode());
				System.out.println("threadSafeObliterator2 hashcode : " + threadSafeObliterator2.hashCode());
				System.out.println();
			} else {
				System.out.println("(serializeDeserializeTest) threadSafeObliterator and threadSafeObliterator2 do not represent the same object.");
				System.out.println("threadSafeObliterator hashcode : " + threadSafeObliterator.hashCode());
				System.out.println("threadSafeObliterator2 hashcode : " + threadSafeObliterator2.hashCode());
				System.out.println("(serializeDeserializeTest) The singleton pattern has been violated");
				System.out.println();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void serializeDeserializeEnumTest() {
		
		try {
			
			MySingletonEnum mySingletonEnum = MySingletonEnum.INSTANCE;
			File file = new File(enumFileName);
			
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(mySingletonEnum);
			
			objectOutputStream.close();
			
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			MySingletonEnum mySingletonEnum2 = (MySingletonEnum)objectInputStream.readObject();
			
			if(file.exists()) {
				file.deleteOnExit();
			}
			objectInputStream.close();
			
			
			if(mySingletonEnum == mySingletonEnum2) {
				System.out.println("(serializeDeserializeEnumTest) Both mySingletonEnum and mySingletonEnum2 represent the same object");
				System.out.println("mySingletonEnum hashcode : " + mySingletonEnum.hashCode());
				System.out.println("mySingletonEnum2 hashcode : " + mySingletonEnum.hashCode());
				System.out.println();
			} else {
				System.out.println("(serializeDeserializeEnumTest) mySingletonEnum and mySingletonEnum2 do not represent the same object.");
				System.out.println("mySingletonEnum hashcode : " + mySingletonEnum.hashCode());
				System.out.println("mySingletonEnum2 hashcode : " + mySingletonEnum.hashCode());
				System.out.println("(serializeDeserializeEnumTest) The singleton pattern has been violated");
				System.out.println();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
