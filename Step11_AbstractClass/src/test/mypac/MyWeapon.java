package test.mypac;

public class MyWeapon extends Weapon { // 1. 추상 클래스를 상속 받으면
	
	// 2. 미완성의 추상 메소드를 반드시 오버라이드 해야한다
	@Override
	public void attack() {
		System.out.println("코로나를 공격해요");
	}

}

// 자식 클래스를 정의 한 다음(만든 다음) 오버라이드 해서 추상 메소드를 자식 클래스에서 완성
// object | Weapon | MyWeapon w=new MyWeapon();