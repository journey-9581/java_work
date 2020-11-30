package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.MemberDto;

public class MainClass06 {
	public static void main(String[] args) {
		// MemberDto 객체의 참조값을 담을 수 있는 ArrayList 객체를 생성해서
		// ArrayList 객체의 참초값을 List type 지역변수 members에 담기
		List<MemberDto> members=new ArrayList<MemberDto>();
		// 3명의 회원 정보를 members 배열에 담아보세요
		members.add(new MemberDto(1, "김지윤", "화정역"));
		members.add(new MemberDto(2, "이현지", "미금역"));
		members.add(new MemberDto(3, "최이지", "건대입구역"));
		
		//(String 제외하고)heap 영역에 4개(ArrayList type 1개, MemberDto type 3개)
		
		// 한 객체의 참조값이 여러군데에 있을 수 있다 -> mem1, ArrayList 안의 각자 방(members안에는 ArrayList의 참조값이)
	
		// mem1의 num 값을 참조하려면 (밑처럼 만들었을 때)
		// mem1.num 은 불가능 -> private 영역이기 때문
		// mem1.getNum(); 은 가능
		// members.get(0).getNum(); 도 가능
		
		// mem2의 addr 값을 참조하려면 (밑처럼 만들었을 때)
		// mem2.getAddr();
		// members.get(1).getAddr();
		
		// members.add(new MemberDto(3, "최이지", "건대입구역"));의 name을 참조하는 방법
		// 지역변수에 담지 않고 객체 생성해서 바로 전달했기 때문에 
		// members.get(2).getName();
		
		/*
		 * members에 들어있는 참조값을 이용해서 반복문 돌면서 아래와 같은 형식으로 회원 정보를 출력해보세요
		 * 
		 * 번호는 1 이름은 김구라 주소는 노량진
		 * 번호는 2 이름은 해골 주소는 행신동
		 * 번호는 3 이름은 원숭이 주소는 상도동
		 */
		
		for(int i=0; i<members.size(); i++) {
			System.out.println(
					"번호는 "+members.get(i).getNum()+
					" 이름은 "+members.get(i).getName()+
					" 주소는 "+members.get(i).getAddr());
		}
		System.out.println("--------------");
		for(int i=0; i<members.size(); i++) {
			MemberDto tmp=members.get(i);
			System.out.println(
					"번호는 "+tmp.getNum()+
					" 이름은 "+tmp.getName()+
					" 주소는 "+tmp.getAddr());
		}
		System.out.println("--------------");
		// 확장 for문
		for(MemberDto tmp:members) { //type(여기서는 MemberDto)의 선언을 잘해야 함, 배열의 제너럴 타입을 적어줘야 함
			System.out.println(
					"번호는 "+tmp.getNum()+
					" 이름은 "+tmp.getName()+
					" 주소는 "+tmp.getAddr());
		}
	}
}

/*
 * MemberDto mem1=new MemberDto();
 * mem1.setNum(1);
 * mem1.setName("김지윤");
 * mem1.setAddr("화정역");
 * members.add(mem1);
 * MemberDto mem2=new MemberDto();
 * ""
 * MemberDto mem3=new MemberDto();
 * ""
 */
/*
 * MemberDto mem1=new MemberDto(1, "김지윤", "화정역")
 * members.add(mem1);
 * ""
 * ""
 */