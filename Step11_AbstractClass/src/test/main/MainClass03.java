package test.main;

import test.mypac.Gun;
import test.mypac.Weapon;

public class MainClass03 {
	// Inner Class (내부 클래스에 한해서 필요하다면 static 예약어를 붙일 수 있다)
	static class AirPlane extends Weapon {

		@Override
		public void attack() {
			System.out.println("공중에서 공격을 해요");
		}
		
	}
	
	public static void main(String[] args) {
		// Local Inner Class
		class Sword extends Weapon {

			@Override
			public void attack() {
				System.out.println("칼로 공격 해요");
			}
		}
		
		// Sword 객체를 생성해서 참조 값을 Weapon type으로 받기 (local inner class)
		Weapon w1=new Sword();
		useWeapon(w1);
		// Airplane 객체를 생성해서 참조 값을 Weapon type으로 받기 (inner class)
		Weapon w2=new AirPlane();
		useWeapon(w2);
		// Gun 객체를 생성해서 참조 값을 Weapon type으로 받기 (external class)
		Weapon w3=new Gun();
		useWeapon(w3);
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
