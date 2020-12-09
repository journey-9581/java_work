package test.main;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MainClass09 {
	public static void main(String[] args) {
		//850번 회원의 정보를 삭제하고자 한다
		
		//이미 만들어진 클래스로 객체를 생성해서
		MemberDao dao=new MemberDao();
		//메소드를 사용하는 사용자 입장이다
		boolean isSuccess=dao.delete(884);
		//위 작업의 성공여부를 알 수 없다
		if(isSuccess) {
			System.out.println("작업(DELETE) 성공");
		}else {
			System.out.println("작업(DELETE) 실패");
		}
		
		MemberDto dto=new MemberDto();
		dto.setNum(1988);
		dto.setName("김구라");
		dto.setAddr("노량진");
		boolean isSuccess2=dao.insert(dto);
		if(isSuccess2) {
			System.out.println("작업(INSERT) 성공");
		}else {
			System.out.println("작업(INSERT) 실패");
		}
		
		MemberDto dto2=new MemberDto();
		dto.setNum(1989);
		dto.setName("김구라");
		dto.setAddr("노량진");
		boolean isSuccess3=dao.insert(dto);
		if(isSuccess3) {
			System.out.println("작업(UPDATE) 성공");
		}else {
			System.out.println("작업(UPDATE) 실패");
		}
		
		
		System.out.println("main 메소드가 종료 되었습니다");
	}
}
