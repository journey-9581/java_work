package test.mypac;

// extends는 어떤 클래스를 상속 받을 때 사용하는 예약어이다
// 어떤 클래스도 extends 하지 않으면 자동으로 Object 클래스를 상속 받게 된다
// 따라서 Object 클래스를 상속받을거라면 생략이 가능하다
public class Phone { // = public class Phone extends Object{
	// public phone () {} : 디폴트 생성자 기본으로 있음
	
	// 전화를 거는 non-static 메소드
	public void call() {
		System.out.println("전화를 걸어요!");
	}
}
