package test.main;

import test.mypac.Rect;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * 1.
		 * 가로 세로의 길이가 100 과 100
		 * 가로 세로의 길이가 200 과 100
		 * 가로 세로의 길이가 300 과 200
		 * 인 사각형 3개가 있다
		 * 
		 * 각각에 대응되는 Rect 객체를 3개 생성해서 참조값을
		 * rect1, rect2, rect3라는 지역 변수에 담아보세요
		 */
			Rect rect1=new Rect(100, 100);
			Rect rect2=new Rect(200, 100);
			Rect rect3=new Rect(300, 200);
		
		/* 
		 * 2. rect1, rect2, rect3에 담긴 참조값을  배열에 순서대로 담아보세요
		 * 배열의 참조값이 담길 지역 변수의 이름은 rects로 선언하세요
		 */
			Rect[] rects=new Rect[3];
				rects[0]=rect1;
				rects[1]=rect2;
				rects[2]=rect3;
		/*
		 * 3. rects 배열에 담긴 값을 순서대로 참조해서 .getArea() 메소드를 호출 한 다음
		 * 리턴 되는 값을 이용해서 사각형의 넓이를 순서대로 콘솔창에 출력해보세요
		 */
			/* for(int i=0; i<rects.length; i++) {
			 * Rect tmp=rects[i];
			 * int area=tmp.getArea();
			 * System.out.println(area);
			 * }
			 */
			for(int i=0; i<rects.length; i++) {
				System.out.println(rects[i].getArea());
			}
	}
}
