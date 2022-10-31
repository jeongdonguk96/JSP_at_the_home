package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {

	public static void main(String[] args) throws Exception {
		// Hello hello = new Hello();
		// hello.main(); // 클래스 Hello의 매서드 main이 private라 사용 불가
		
		// 접근제어자가 private인 매서드 main을 다른 클래스에서 사용하는 방법
		// Reflection API를 사용 : 클래스 정보를 얻고 다룰수 있는 강력한 기능 제공
		// java.lang.reflect 패키지를 제공
		
		// Hello클래스의 Class객체를 얻어온다. (클래스의 정보를 담고 있는 객체)
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		
		Hello hello = (Hello)helloClass.newInstance(); // Class 객체가 가진 정보로 객체 생성
		
		Method main = helloClass.getDeclaredMethod("main");
		
		main.setAccessible(true); // private인 매서드 main을 호출 가능하게하 함
		
		main.invoke(hello); // hello.main() 과 같음
	}
}
