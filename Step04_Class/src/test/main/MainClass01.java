package test.main;

import test.mypac.Car;

public class MainClass01 {
	public static void main(String[] args) {
		//Car type 의 참조값을 담을수 있는 빈 지역 변수 car1 만들기 
		Car car1=null;
		//Car 클래스로 객체를 생성(new)하고 그 생성된 객체의 참조값을 car1 에  대입하기
		car1=new Car();
		
		//car1 지역 변수에 있는 참조값을 이용해서 메소드 호출하기 
		car1.drive();
		car1.hotHip();
	}
}

// new Car(); -> 객체가 생성됨(new 할 때마다) -> heap 영역에 물건(객체=object)이 만들어진다 -> 그 물건의 위치가 참조값
// 자바스크립트는 단독으로 함수가 존재 가능 했지만 java에서는 메소드가 단독으로 존재할 수 없고 static 영역의 클래스 안에 존재하던지 객체 안에 존재해야 함
