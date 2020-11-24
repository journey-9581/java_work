package test.mypac;

public class FruitBox<T> { // <T>: generic class, T 자리에는 뭐든 쓸 수 있지만 보통 T
	public T item; // Field type (class 설계 단계에서는 미정)
	
	public void setItem(T item) {
		this.item=item;
		
	}
	
	public T getItem() {
		return this.item;
	}
}

// 객체 생성 시 : new FruitBox<Apple>(); | new FruitBox<Banana>(); ...