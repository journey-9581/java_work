package test.main;

import test.mypac.Weapon;

public class MainClass05 {
	public static void main(String[] args) {
		// 익명 클래스를 이용해서 1회용 Weapon type의 참조값 얻어내서 메소드 호출하기
		useWeapon(new Weapon() {
			@Override
			public void attack() {
				System.out.println("고양이를 공격해요");
			}
			
		}); // 일회용으로 전달하고 말거라면 이렇게도 가능
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
