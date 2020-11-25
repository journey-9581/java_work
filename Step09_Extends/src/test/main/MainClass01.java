package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass01 {
	// main 메소드의 역할: run 했을 때 application의 시작 도입점이 되는 main 메소드
	public static void main(String[] args) {
		Phone p1=new Phone();
		HandPhone p2=new HandPhone();
		// 부모 클래스(Phone)에 정의된 메소드 호출 가능
		p2.call();
		// 자식 클래스(HandPhone)에 추가된 메소드는 당연히 호출 가능
		p2.mobileCall();
		p2.takePicture();
	}
}

// object <-(extends)- Phone <-(extends)- HandPhone
// new HandPhone. = object 와  Phone까지
// new Phone. = object까지