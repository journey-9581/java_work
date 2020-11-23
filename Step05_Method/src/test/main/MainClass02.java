package test.main;

import test.mypac.House;

public class MainClass02 {
	public static void main(String[] args) {
		// House 클래스를 이용해서 여러분들이 집에서 편안하게 3번 쉬어보세요
			House home=new House();
			home.relex("김지언");
			home.relex("김지언");
			home.relex("김지언");
		// 집에서 100번 쉬어보세요
			for(int i=0; i<100; i++) {
				home.relex("김지언");
			}
	}
}