package test.main;
//test.(<-하위폴더)main

public class MainClass01 {
	// run 했을 때 실행 순서가 시작되는 특별한 main 메소드
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다");
		// data type 명시 + 변수명 = 값
		
		// 정수형 변수 선언하고 값 대입하기
		// 정수형: byte, short, int, long
		byte a=10; // -128 ~ 127
		short b=10; // -32768 ~ 32767
		int c=10; // -2,147,483,648 ~ 2,147,483,647 | 가장 많이 사용
		long d=10; // -9223372036854775808 ~ 9,223,372,036,854,775,807
		
		// 실수형 변수 선언하고 값 대입하기
		// 실수형: float, double
		float e=10.1f; // 1.40129846432481707e-45 ~ 3.40282346638528860e+38 | float를 사용할 때는 뒤에 f를 붙여줘야 함
		double f=10.1d; // 4.94065645841246544e-324d ~ 1.79769313486231570e+308d
		double g=10.1; // double은 뒤에 d를 생략 가능
	}
}