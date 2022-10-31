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
public class YoiltellerMVC_ModelAndView { // ������� �Է��ϸ� ������ �˷��ִ� ���α׷�

	@RequestMapping("/getYoilMVC")
      	// String�� ModelAndView Ÿ������ �ٲ� : �𵨰� ���� ������ ���ÿ� �ϴ� Ŭ����
	public ModelAndView main(int year, int month, int day) throws IOException {
		// �Ķ���ͷ� ���� ���� �ʰ� ��ü�� ������ ����
		
		// 1. �𵨰� �並 ���� ��ü ����
		ModelAndView mv = new ModelAndView();
		
		// 1. ��ȿ�� �˻�
		// if(!isValid(year, month, day))
		//	return "yoilError";
		
		// 2. ���� ���
		char yoil = getYoil(year, month, day); 
		
		// 3. ����� ����� model�� ����
		mv.addObject("year", year); // addAtrribute�� �ƴ� addObject �ż���
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("yoil", yoil);
		
		// 4. ����� ������ view�� ����
		mv.setViewName("yoil"); // view�� �̸��� �����ϴ� �ż���
		
		return mv;
	}

	private boolean isValid(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month -1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // DAY_OF_WEEK : 1~7������ ���ڷ� ��~�� ������ ��ȯ�ϴ� �ż���
		return "�Ͽ�ȭ�������".charAt(dayOfWeek); // charAt : �ڿ� ���� ���ڿ� ������ �� ���ڿ��� �ε��� ����
	}

}
