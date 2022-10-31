package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoiltellerMVC_void { // 년월일을 입력하면 요일을 알려주는 프로그램

	@RequestMapping("/getYoilMVC") // 반환되는 게 없기 때문에 매핑된 URL에 의해 view가 지정 - yoil_void.jsp를 사용
      	// 반환 없이도 void로 가능
	public void main(int year, int month, int day, Model model) throws IOException {
		// request라는 요청(입력과정)을 파라미터로 바로 주고, response라는 응답을 Model로 대신함 
		
		// 1. 유효성 검사
		// if(!isValid(year, month, day))
		//	return "yoilError";
		
		// 2. 요일 계산
		char yoil = getYoil(year, month, day); 
		
		// 3. 계산한 결과를 model에 저장
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
	}

	private boolean isValid(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month -1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // DAY_OF_WEEK : 1~7까지의 숫자로 일~토 요일을 변환하는 매서드
		return "일월화수목금토".charAt(dayOfWeek); // charAt : 뒤에 오는 숫자와 동일한 앞 문자열의 인덱스 지정
	}

}
