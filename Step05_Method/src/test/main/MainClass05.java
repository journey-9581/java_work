package test.main;

import test.mypac.House;
import test.mypac.MyObject;
import test.mypac.Phone;

public class MainClass05 {
	public static void main(String[] args) {
		// 1. MyObject 클래스의 callPhone() 메소드를 호출해보세요
		MyObject.callPhone(new Phone());
		// 2. MyObject 클래스의 buyHouse() 메소드를 호출하고 리턴되는 참조값을 myHome이라는 이름의 지역 변수에 담아보세요
		House myHome=MyObject.buyHouse();
	}
}

// static이 붙었을땐 클래스명에 점 찍어서 호출 (static 영역에서 생성되니깐)