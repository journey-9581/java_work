package test.mypac;

// 미완성의 메소드를 멤버로 가지고 있으려면 abstract 예약어를 붙인다
public abstract class Weapon {
	// 무기 작동을 준비하는 메소드
	public void prepare() {
		System.out.println("무기 작동을 준비합니다");
	}
	// 공격하는 메소드
	public abstract void attack(); // 미완성의 메소드를 만들 때 abstract 예약어를 붙인다
}
