package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YoiltellerMVC_ModelAndView { // 년월일을 입력하면 요일을 알려주는 프로그램

	@RequestMapping("/getYoilMVC")
      	// String을 ModelAndView 타입으로 바꿈 : 모델과 뷰의 역할을 동시에 하는 클래스
	public ModelAndView main(int year, int month, int day) throws IOException {
		// 파라미터로 모델을 받지 않고 객체를 생성해 담음
		
		// 1. 모델과 뷰를 담을 객체 생성
		ModelAndView mv = new ModelAndView();
		
		// 1. 유효성 검사
		// if(!isValid(year, month, day))
		//	return "yoilError";
		
		// 2. 요일 계산
		char yoil = getYoil(year, month, day); 
		
		// 3. 계산한 결과를 model에 저장
		mv.addObject("year", year); // addAtrribute가 아닌 addObject 매서드
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("yoil", yoil);
		
		// 4. 결과를 보여줄 view를 지정
		mv.setViewName("yoil"); // view의 이름을 설정하는 매서드
		
		return mv;
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
