package test.main;

import test.auto.Car;
import test.auto.Engine;

public class MainClass09 {
	public static void main(String[] args) {
		// default 생성자가 없으므로 Car car1=new Car(); 생성 불가능
		Car car1=new Car(new Engine());
		car1.drive();
	}
}
