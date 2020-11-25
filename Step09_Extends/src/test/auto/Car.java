package test.auto;

public class Car {
	// protected 접근 지정자를 지닌 필드
	protected Engine engine;
	
	// Engine type을 인자로 전달 받는 생성자
	public Car(Engine engine) { // 새로운 객체를 만들 때 : new Car(new Engine());
		this.engine=engine;
	}
	
	// 메소드
	public void drive() {
		if(this.engine==null) {
			System.out.println("Engine이 없어서 달릴 수가 없어요!");
			return; // 메소드 끝내기
		}
		System.out.println("달려요!");
	}
}
