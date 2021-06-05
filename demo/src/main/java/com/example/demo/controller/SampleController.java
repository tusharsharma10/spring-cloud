package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.PlatformKeeper;

@RestController
public class SampleController {

	@ResponseBody
	@PostMapping("/local")
	public void checkThreadLocal(@RequestHeader String lang,
			@RequestHeader String platform) {
		
		System.out.println(PlatformKeeper.language);
		System.out.println(PlatformKeeper.platform);
		
		
		
		PlatformKeeper.language.set(lang);
		PlatformKeeper.platform.set(platform);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(PlatformKeeper.language.get());
		System.out.println(PlatformKeeper.platform.get());
		
	}
	
	@ResponseBody
	@GetMapping("/get/local")
	public void checkThreadLocal2(@RequestHeader String lang,
			@RequestHeader String platform) {
		
		System.out.println(PlatformKeeper.language);
		System.out.println(PlatformKeeper.platform);
		
//		System.out.println(SimpleKeeper.language);
//		System.out.println(SimpleKeeper.platform);
		
//		SimpleKeeper.language = lang;
//		SimpleKeeper.platform = platform;
		
		
		
		PlatformKeeper.language.set(lang);
		PlatformKeeper.platform.set(platform);
		
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(PlatformKeeper.language.get());
		System.out.println(PlatformKeeper.platform.get());
	}
	
	
	
	
	@PostMapping("/map")
	public void post(@RequestBody Map<String,Object> m) {
		
		System.out.println(   ((Map<String,Object>) m.get("data")).get("goals")  );
		
	}
	
	@GetMapping("/get/name")
	public String getName() {
		
		return "tushar sharma";
	}
	
	
}
