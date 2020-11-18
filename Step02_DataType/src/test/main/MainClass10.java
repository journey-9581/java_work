package test.main;

public class MainClass10 {
	public static void main(String[] args) {
		// 기본 데이터 type
		int num=10;
		double num2=10.1;
		char ch1='a';
		
		// 참조 데이터 type
		String str="abcde12345";
		
		// 참조 데이터 type에는 기능들을 사용할 수 있다
		// length() 메소드는 문자열의 길이를 리턴한다
		int size=str.length();
		// charAt() 메소드는 문자열에서 인자로 주어진 값에 해당하는 문자를 리턴한다
		char ch=str.charAt(5);
		// toUpperCase() 메소드는 소문자를 모두 대문자로 변환한 문자열 얻어낸다
		String result=str.toUpperCase();
	}
}