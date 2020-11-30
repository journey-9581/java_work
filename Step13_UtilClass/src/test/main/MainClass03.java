package test.main;

import java.util.ArrayList;
import java.util.List;

public class MainClass03 {
	public static void main(String[] args) {
		// 친구 목록이라고 가정하자
		String name1="김구라";
		String name2="해골";
		String name3="원숭이";
		
		// 만일 아래와 같이 담는다면 방의 크기를 동적으로 조절할 수가 없다
		// String[] name={"김구라", "해골", "원숭이};
		
		List<String> names=new ArrayList<String>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		
		// 각각의 방에 저장된 값 불러오기
		String n1=names.get(0);
		String n2=names.get(1);
		String n3=names.get(2);
		
		// 방의 사이즈 참조
		int size=names.size();
		
		names.set(0, "주뎅이");
		
		// 특정 인덱스의 방 삭제하기
		names.remove(1);
		
		// 전체 삭제
		names.clear();
	}
}

// new ArrayList();
// new ArrayList<HashMap<String, Object>>();