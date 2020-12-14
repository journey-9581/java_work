package json;

import org.json.JSONArray;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 * 인터넷으로부터 다운받은 문자열이 JSON 형식인 경우도 많이 발생한다
		 * 해당 문자열에서 원하는 정보를 추출하는 연습을 해보자
		 */
		
		String info="[10, 20, 30, 40, 50]";
		//위의 문자열에서 숫자만 순서대로 추출해서 콘솔창에 순서대로 출력할 수 있을까?
		JSONArray nums=new JSONArray(info);
		/*
		 * nums에 들어있는 참조값을 이용해서(JSONArray 객체의 메소드를 이용해서)
		 * 
		 * 0번째 인덱스: 10
		 * 1번째 인덱스: 20
		 * .
		 * .
		 * 4번째 인덱스: 50
		 * 
		 * 위와 같은 형식으로 콘솔창에 출력해보세요
		 */
		for(int i=0; i<nums.length(); i++) {
			System.out.println(i+"번째 인덱스: "+nums.getInt(i));
		}
	}
}
