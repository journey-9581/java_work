package test.main;

/*
 *  [ java 참조 데이터 type ]
 *  
 *  String type
 *  
 *  - 문자열을 다룰 때 사용하는 데이터 type이다
 *  - 참조 데이터 type 변수에는 참조값(id) 값이 들어있다
 */

public class MainClass07 {
	public static void main(String[] args) {
		System.out.println("main 메소드가  시작되었습니다");
		// "김구라"라는 String type 참조값을 name이라는 지역변수에 대입
		String name="김구라";
		// name 안에 들어있는 참조값을 myName이라는 새로운 변수에 대입
		String myName=name;
		// "원숭이"라는 String type 참조값을 name에 덮어쓰기 (새로 대입)
		name="원숭이";
		// String type 참조값이 들어갈 수 있는 지역변수 name을 빈 상태로 만들기
		// null은 참조 데이터 type이 들어갈  수 있는 빈 공간을 의미한다
		name=null;
	}
}
