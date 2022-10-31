package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Yoilteller { // ������� �Է��ϸ� ������ �˷��ִ� ���α׷�

	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. �Է�
		String year = request.getParameter("year"); // �Ķ���Ϳ� ���� "year"�� name. ���� value�� �Ķ���ͷ� �Է�
		String month = request.getParameter("month");
		String day = request.getParameter("day");

		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);

		// 2. ó�� = Controller
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm -1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // DAY_OF_WEEK : 1~7������ ���ڷ� ��~�� ������ ��ȯ�ϴ� �ż���
		char yoil = "�Ͽ�ȭ�������".charAt(dayOfWeek); // charAt : �ڿ� ���� ���ڿ� ������ �� ���ڿ��� �ε��� ����
		
		// 3. ��� = View
		response.setContentType("text/html"); // ������ ������ text�߿� html�� ���� 
		response.setCharacterEncoding("utf-8"); // ������ ���ڵ��� utf-8�� ����
		PrintWriter out = response.getWriter(); // response��ü���� ���������� ��� ��Ʈ���� ��´�.
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println(year + "�� " +  month + "�� " +  day + "����");
		out.println(yoil + "�����Դϴ�.");
		out.println("</body>");
		out.println("</html>");
	}

}
