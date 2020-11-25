package test.main;

import test.mypac.Phone;

public class MainClass08 {
	public static void main(String[] args) {
		Phone p1=null;
		Phone p2=new Phone();
		
		MainClass08.usePhone(p1);
		System.out.println("---------");
		MainClass08.usePhone(p2);
	}
	
	public static void usePhone(Phone p) {
		// 여기에서 NullPointerException을 방지하는 방법이 있을까요?
		if(p != null) {
			p.call();
		}
	}
}
