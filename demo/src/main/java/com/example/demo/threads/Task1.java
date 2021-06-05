package com.example.demo.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class Task1 implements Callable<String>{

	CountDownLatch cdLatch;
	
	public Task1(CountDownLatch cdLatch) {
		
		this.cdLatch = cdLatch;
	}
	
	
	
	@Override
	public String call() throws Exception {
		
		
		
		return myCall();
		
	}
	
	//long task simulation
	public String myCall() {
		
		// sleep denotes some computation time
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getId()+" Inside task1");
		cdLatch.countDown();
		return "data from task1 "+Thread.currentThread().getId();
		
	}
	

}
