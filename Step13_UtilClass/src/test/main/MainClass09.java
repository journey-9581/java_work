package test.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/*
 * HashSet 클래스는 Set 인터페이스를 구현한 클래스이다
 * - 저장된 데이터를 순서없이 무작위로 관리한다
 * - key 값도 없다
 * - 중복을 허용하지 않는다 (같은 값이 두개 이상 존재 할 수 없다)
 * - 어떤 data를 묶음 (집합)으로 관리 하고자 할 때 사용한다
 * - 중복된 데이터를 제거 할 때도 유용하다
 */

public class MainClass09 {
	public static void main(String[] args) {
		Set<Integer> set1=new HashSet<Integer>();
		set1.add(10);
		set1.add(20);
		set1.add(30);
		set1.add(30);
		
		// 어떤 data가 Set에 있는지 여부를 리턴하는 메소드 (전달한 값이 포함되어있는지 확인)
		boolean result1=set1.contains(10); // true
		boolean result2=set1.contains(50); // false
		
		// Set이 비어 있는지 여부를 리턴
		boolean result3=set1.isEmpty(); // false
		
		// 저장된 아이템의 갯수
		int result4=set1.size(); // 3
		
		// 정수가 일렬로 담겨진 Iterator 객체의 참조값 얻어내기
		Iterator<Integer> it=set1.iterator();
		
		// true면 무한반복, false면 반복하지 않음 | hasNext(); : 일렬로 있는 데이터-> 다음이 있으면 true, 없으면 false
		// 커서 다음에 데이터가 있으면
		while(it.hasNext()) {
			// 커서를 다음 데이터로 옮겨서 해당 데이터를 읽어낸다
			Integer tmp=it.next();
			// 읽어낸 데이터 콘솔 출력하기
			System.out.println(tmp); // 집어넣은 순서대로 나오지는 않음
		}
	}
}