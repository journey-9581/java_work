package test.mypac;
/*
 *  static 자원을 포함하는 용도로 사용해 보기
 */
public class MyUtil {
	// non static 필드
	public int version;
	
	// static 필드
	public static String owner;
	
	public static void playMusic() {
		System.out.println("음악을 틀어요!");
		
		/*
		 * int a = this.version; // 불가능 (영역이 다름)
		 * int b = MyUtil.version; // 불가능 (영역이 다름)
		 */
		String c=MyUtil.owner; // 가능
	}
}

// static: class 자체가 field와 메소드를 가질 수 있게 함
// 객체처럼 여러개를 가지지 않음, 오직 하나만 만들어짐

// static에서는 this가 의미가 없음 (객체와 연관)