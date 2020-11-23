package test.main;

import test.mypac.MyObject;
import test.mypac.Phone;

public class MainClass04 {
	public static void main(String[] args) {
		//MyObject 클래스에 있는 usePhone() 메소드를 호출해보세요
			MyObject o1=new MyObject();
			Phone p1=new Phone();
			o1.usePhone(p1);
			
			System.out.println("- 위와 동일한 작업을 2줄의 코딩으로 한다면");
			MyObject o2=new MyObject();
			o2.usePhone(new Phone());
			
			System.out.println("- 위와 동일한 작업을 1줄의 코딩으로 한다면");
			new MyObject().usePhone(new Phone()); // 이 전체는 type이 없음 (void기 때문에) = 무언가를 담을 수 없음
	}
}
