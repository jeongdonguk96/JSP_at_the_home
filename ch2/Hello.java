package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	
	String iv = "it's iv";
	static String cv = "it's cv";
	
	@RequestMapping("/hello")
	private void main() {
		System.out.println("Hello! - it's private method");
		System.out.println(iv);
		System.out.println(cv);
	}
}
