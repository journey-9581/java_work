package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다");
		float num1=10.1f;
		double num2=10.2d; // d 생략 가능
		// 범위가 상대적으로 double보다 작은 float type 변수에 담긴 값을 double type 변수에 담는 것은 가능하다
		double a=num1;
		
		// 범위가 넓은 double type 변수에 있는 값을 float type에 담을 때는 casting이 필요하다
		float b=(float)num2;
	}
}
