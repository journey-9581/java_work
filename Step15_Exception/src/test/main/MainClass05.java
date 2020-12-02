package test.main;
/*
 * Exception의 종류는 크게 두 가지이다
 * 
 * 1. RuntimeException을 상속 받아서 만든 실행 중에 발생하는 Exception
 * 
 * 2. RuntimeException을 상속 받지 않아서 만든 컴파일(문법 체크 중) 중에 발생하는 Exception
 */
public class MainClass05 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다");
		
		try {
			//스레드(작업 단위, Thread)를 5초 잡아두기
			//반드시 try~catch 블럭으로 예외처리를 해야한다
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main 메소드가 종료됩니다");
	}
}
