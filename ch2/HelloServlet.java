package com.fastcampus.ch2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
	 // 1. 서블릿의 초기화 작업 담당 - 서블릿이 생성 또는 리로딩될 때 단 한번만 수행
	@Override 
	public void init() throws ServletException { // 서블릿이 초기화될 때 자동 호출되는 매서드
		System.out.println("[HelloServlet] init() is called");
	}
	
	// 2. 호출될 때마다 반복적으로 수행
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 입력
		// 2. 처리
		// 3. 출력
		System.out.println("[HelloServlet] service() is called");
	}
	
	// 3. 뒷정리 작업 - 서블릿이 제거(unload)될 때 서블릿 컨테이너에 의해 단 한번만 수행
	@Override
	public void destroy() {
		System.out.println("[HelloServlet] destroy() is called");
	}
	
}
