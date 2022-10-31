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
public class YoiltellerMVC_void { // ������� �Է��ϸ� ������ �˷��ִ� ���α׷�

	@RequestMapping("/getYoilMVC") // ��ȯ�Ǵ� �� ���� ������ ���ε� URL�� ���� view�� ���� - yoil_void.jsp�� ���
      	// ��ȯ ���̵� void�� ����
	public void main(int year, int month, int day, Model model) throws IOException {
		// request��� ��û(�Է°���)�� �Ķ���ͷ� �ٷ� �ְ�, response��� ������ Model�� ����� 
		
		// 1. ��ȿ�� �˻�
		// if(!isValid(year, month, day))
		//	return "yoilError";
		
		// 2. ���� ���
		char yoil = getYoil(year, month, day); 
		
		// 3. ����� ����� model�� ����
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
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // DAY_OF_WEEK : 1~7������ ���ڷ� ��~�� ������ ��ȯ�ϴ� �ż���
		return "�Ͽ�ȭ�������".charAt(dayOfWeek); // charAt : �ڿ� ���� ���ڿ� ������ �� ���ڿ��� �ε��� ����
	}

}
