package test.main;

import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass11 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다");
		/*
		 * 콘솔창을 확인해서 부모 객체가 미리 만들어지는 것을 체크하세요
		 */
		
		Object p1=new SmartPhone();
		Phone p2=new SmartPhone();
		// 각각 다른 참조 값, 각자가 다른 하나의 묶음으로 관리가 된다는 것을 확인 가능
		
		System.out.println("main 메소드가 종료됩니다");
	}
}
