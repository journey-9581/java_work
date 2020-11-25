package test.main;

import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass05 {
	public static void main(String[] args) {
		Phone p1=new Phone(); // new Phone(); : type Object 와 Phone만 가지고 있는데
		
		SmartPhone p2=(SmartPhone)p1; // SmartPhone으로 casting 했다고 해서
		
		p2.doInternet(); // SmartPhone의 기능을 쓸 수는 없다
	}
}
