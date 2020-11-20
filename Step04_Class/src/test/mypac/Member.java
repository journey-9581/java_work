package test.mypac;

public class Member {
	public int num;
	public String name;
	public String addr;
	
	public void showInfo() {
		System.out.println("----- 정보 -----");
		System.out.println("번호: "+this.num);
		System.out.println("이름: "+this.name);
		System.out.println("주소: "+this.addr);
		System.out.println("--------------");
	}
}


//this: 객체 자신의 참조값을 가르키는 예약어 (클래스 설계 단계에서 아직 정해지지 않은 참조값을 선택하고 싶을 때 사용)