package test.main;
/*
 * Scanner 객체를 이용해서 검색할 회원의 번호를 입력 받아서
 * 입력받은 숫자를 이용해서 SELECT문을 수정하고
 * 결과값을 MemberDto 객체를 생성해서 담아보세요
 * 
 * 결과가 없다면 MemberDto 객체를 생성하지 마세요
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import test.member.dto.MemberDto;
import test.util.DBConnect;

public class MainClass07 {
	public static void main(String[] args) {
		
		
		//콘솔창 스캔
		Scanner scan=new Scanner(System.in);
		System.out.println("검색할 회원 정보 입력:");
		int num=scan.nextInt();
				
		//필요한 객체를 담길 MemberDto 객체의 참조값을 담을 지역변수
		MemberDto dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
				
		try {
			//DBConnet 객체를 이용해서 Connection 객체의 참조값 얻어내기
			DBConnect dbconn=new DBConnect();
			conn=dbconn.getConn();
			
			//실행한 sql문(SELECT)의 뼈대 구성하기(아직 미완성이기 때문에 뼈대)
			String sql="select name,addr from member where num=?";
			//sql문을 대신 실행해줄 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			//?에 값 바인딩 하기
			pstmt.setInt(1, num);
			//SELECT문 수행하고 결과를 ResultSet으로 받기
			rs=pstmt.executeQuery();
			if(rs.next()) {//select 된 결과가 있다면
				//MemberDto 객체를 생성해서
				dto=new MemberDto();
				//setter 메소드를 이용해서 값을 담는다
				dto.setNum(num);
				//ResultSet 객체에 있는 값도 얻어와서 담아준다
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				}
		}catch(Exception e) {
			e.printStackTrace();
			}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				if(rs!=null)rs.close();
			}catch(Exception e) {
				
			}
		}
		//위의 try~catch~finally절이 수행된 후에 select된 결과가 있는 지 없는지를
		//여기에서 쉽게 판별할 수 있는 방법이 있나요?
		if(dto==null) {
			System.out.println(num+"번 회원은 존재 하지 않습니다");
		}else {
			System.out.println("번호:"+dto.getNum()+", 이름:"+dto.getName()+", 주소:"+dto.getAddr());
		}
	}
}

//SELECT -> .executeQuery() 후 ResultSet로 받기
//INSERT, UPDATE, DELETE -> .executeUpdate() 후 int로 받기 