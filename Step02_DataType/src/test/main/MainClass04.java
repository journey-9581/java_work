package test.main;

public class MainClass04 {
	public static void main(String[] args) { // main + ctrl + space 
		System.out.println("main 메소드가 시작 되었습니다"); // syso + ctrl + space
		
		/*
		 *  1. 각각의 점수를 지역변수 eng, kor, math에 대입해보세요
		 *  영어점수: 100
		 *  국어점수: 100
		 *  수학점수: 90
		 */
		
		int eng=100;
		int kor=100;
		int math=90;
		
		// 2. eng, kor, math 세 점수의 합을 구해서 sum이라는 이름의 지역 변수에 담아보세요
		int sum=eng+kor+math;
		// int type과 int type을 연산하면 결과는 int type만 나온다
		
		// 3. eng, kor, math 의 평균 값을 구해서 ave라는 이름의 지역 변수에 담아보세요
		double ave=sum/3;
		
		// 4. ave 안에 들어있는 값을 콘솔창에 출력해보세요
		System.out.println(ave);
	}
}

/* 
 * 왜 double로 설정했음에도 96.66666... 이 아닌 96.0이 나오는가?
 * -int type과 int type을 연산하면 결과는 int type만 나온다
 *  만일 정확한 실수 값을 얻어내고 싶으면 연산에 참여하는 데이터 중에 어느 하나가 실수 type이 되어야 실수 type이 결과로 나온다
 *  
 *  double ave=(double)sum/3; -> 96.66666...
 */