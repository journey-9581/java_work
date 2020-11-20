package test.mypac;
/*
 *  static 자원을 포함하는 용도로 사용해 보기
 */
public class MyUtil {
	
	public static String owner;
	
	public static void playMusic() {
		System.out.println("음악을 틀어요!");
	}
}

// static: class 자체가 field와 메소드를 가질 수 있게 함
// 객체처럼 여러개를 가지지 않음, 오직 하나만 만들어짐