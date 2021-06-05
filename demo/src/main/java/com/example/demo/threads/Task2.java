package com.example.demo.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class Task2 implements Callable<String>{

	CountDownLatch cdLatch;
	
	public Task2(CountDownLatch cdLatch) {
		
		this.cdLatch = cdLatch;
	}
	
	
	
	@Override
	public String call() throws Exception {
		
	
		
		return myCall();
		
	}
	
	//long task simulation
	public String myCall() {
		
		// sleep denotes computation task time
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getId()+" Inside task2");
		cdLatch.countDown();
		return "data from task2 " + Thread.currentThread().getId();
		
	}
	

}
