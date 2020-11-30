package test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass05 {
	/*
	 * 1. 문자열을 저장할 수 있는 ArrayList 객체를 생성하고
	 * 2. Scanner 객체를 이용해서 친구 이름을 반복문 돌면서 5개 입력 받아서
	 *    위에서 생성한 ArrayList 객체에 순서대로 저장을 하세요
	 * 3. ArrayList 객체에 저장된 내용을 반복문 돌면서 순서대로 아래와 같은 형식으로
	 *    콘솔창에 출력해보세요
	 *    
	 * 0 번째 친구 이름: 김구라
	 * 1 번째 친구 이름: 해골
	 * 2 번째 친구 이름: 원숭이
	 * 3 "
	 * 4 "
	 */
	
	public static void main(String[] args) {
		List<String> list1=new ArrayList<>();
		for(int i=0; i<5; i++) {
			Scanner scan1=new Scanner(System.in);
			String line1=scan1.nextLine();
			list1.add(line1);
		}
		
		for(int i=0; i<5; i++) {
			System.out.println(i+" 번째 친구 이름: "+list1.get(i));
		}
		
	}
}
