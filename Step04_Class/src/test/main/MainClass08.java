package test.main;

import test.war.Marine;
import test.war.Pentagon;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 * [ 프로그래밍의 목적 ]
		 * 
		 * 1. 사령부에서 전쟁을 선언하고
		 * 2. 마린을 움직여서
		 * 3. 마린으로 공격하고
		 * 4. 사령부에서 전쟁을 종료
		 */
		
		Pentagon.startWar(); //Pentagon class에 static으로 존재
		Marine marine1=new Marine(); //non static -> new Marine();
		marine1.move();
		marine1.attack();
		Pentagon.endWar();
	}
}
