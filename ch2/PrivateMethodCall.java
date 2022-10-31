package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {

	public static void main(String[] args) throws Exception {
		// Hello hello = new Hello();
		// hello.main(); // Ŭ���� Hello�� �ż��� main�� private�� ��� �Ұ�
		
		// ���������ڰ� private�� �ż��� main�� �ٸ� Ŭ�������� ����ϴ� ���
		// Reflection API�� ��� : Ŭ���� ������ ��� �ٷ�� �ִ� ������ ��� ����
		// java.lang.reflect ��Ű���� ����
		
		// HelloŬ������ Class��ü�� ���´�. (Ŭ������ ������ ��� �ִ� ��ü)
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		
		Hello hello = (Hello)helloClass.newInstance(); // Class ��ü�� ���� ������ ��ü ����
		
		Method main = helloClass.getDeclaredMethod("main");
		
		main.setAccessible(true); // private�� �ż��� main�� ȣ�� �����ϰ��� ��
		
		main.invoke(hello); // hello.main() �� ����
	}
}
