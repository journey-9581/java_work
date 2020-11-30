package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Car;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * 1. Car type의 참조값을 담을 수 있는 ArrayList 객체를 생성해서
		 *    ArrayList 객체의 참조값을 cars라는 이름의 지역 변수에 담아보세요
		 * 
		 * 2. new Car("차의 이름")과 같은 형식으로 Car 객체를 3개 생성해서
		 *    cars에 들어있는 참조값을 이용해서 배열에 참조값을 담아보세요
		 *    
		 * 3. 반복문 돌면서 cars 안에 들어 있는 Car 객체의 참조값을 하나씩 순서대로
		 *    참조해서 .drive() 메소드를 호출해보세요
		 *    
		 *    (콘솔창에 무언가를 출력 x, drive() 메소드 호출)
		 */
		
		List<Car> cars=new ArrayList<>();
		Car car1=new Car("소나타");
		Car car2=new Car("티코");
		Car car3=new Car("제네시스");
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		
		for(Car tmp:cars) {
			tmp.drive();
		}
	}
}