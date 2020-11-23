package test.main;

import test.mypac.House;
import test.mypac.MyObject;

public class MainClass03 {
	public static void main(String[] args) {
		// MyObject 객체를 생성해서 참조값을 m1이라는 이름의 지역 변수에 대입해보세요
			MyObject m1=new MyObject();
		// m1에 있는 참조값을 이용해서 House 객체의 참조값을 얻어와서 myHome이라는 이름의 지역 변수에 담아보세요
			House myHome=m1.getHouse();
		// myHome 안에 있는 참조값을 이용해서 집에서 3번 쉬어보세요
			myHome.relex("김지언");
			myHome.relex("김지언");
			myHome.relex("김지언");
	}	
}

// 필요한 객체를 항상 직접 생성하는 것이 아닌 이미 만들어진 객체를 이용하거나 메소드를 통해 받아오는 경우도 있다