package test.main;

import test.mypac.Weapon;

public class MainClass04 {
	public static void main(String[] args) {
		/*
		 * Weapon 추상 클래스를 상속 받은 익명의 local inner 클래스를 이용하여
		 * Weapon type의 참조값을 얻어내서 w1이라는 Weapon type의 지역변수에 담기
		 */
		Weapon w1=new Weapon() {
			@Override
			public void attack() {
				System.out.println("아무거나 공격해요");
			}
		}; // 이름이 없는 익명의 클래스 + extends Weapon이 된 클래스 + new Weapon()은 이름이 없는 클래스의 생성자를 호출했다고 간주
		useWeapon(w1);
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}