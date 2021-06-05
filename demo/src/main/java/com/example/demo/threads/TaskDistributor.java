package com.example.demo.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class TaskDistributor {

	static ThreadPoolTaskExecutor executor;
	
	
	@PostConstruct
	public void init() {
		
		executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(30);
		executor.setMaxPoolSize(50);
		executor.setQueueCapacity(30);
		executor.setKeepAliveSeconds(5);
		
		executor.initialize();
		
	}
	
	
	
	public void distribute() {

		CountDownLatch cdLatch = new CountDownLatch(30);

		try {

			for (int i = 1; i <= 16; i++) {

				Task1 t = new Task1(cdLatch);
				Future<String> res = executor.submit(t);
			}

			for (int i = 1; i <= 16; i++) {

				Task2 t = new Task2(cdLatch);
				Future<String> res = executor.submit(t);

			}

			cdLatch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	
}
