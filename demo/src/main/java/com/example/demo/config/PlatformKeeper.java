package com.example.demo.config;

// not a spring managed bean so 
//we will create its object at our will
public class PlatformKeeper {

public static final ThreadLocal<String> platform = new ThreadLocal<>();
public static final ThreadLocal<String> language = new ThreadLocal<>();
	

public static void remove() {
	
	platform.remove();
	language.remove();
}
	
}
