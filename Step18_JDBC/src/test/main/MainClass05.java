package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

/*
 * member 테이블에서
 * 회원번호가 801번 회원의 정보를 삭제하는 기능을 완성해보세요
 */
public class MainClass05 {
	public static void main(String[] args) {
		//삭제할 회원의 번호
		int num=801;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		
		try {
			//Connection 객체의 참조값 얻어오기
			DBConnect dbconn=new DBConnect();
			//실행할 sql문의 뼈대 준비하기
			conn=dbconn.getConn();
			String sql="delete from member where num=?";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			//?에 값 바인딩 하기
			pstmt.setInt(1, num);
			//sql문 실행하고 변화된 row의 갯수 리턴 받기
			flag=pstmt.executeUpdate();
			System.out.println("회원 정보를 삭제했습니다");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//마무리 작업
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				
			}
		}
		if(flag>0) {
			System.out.println("작업(DELETE) 성공");
		}else {
			System.out.println("작업(DELETE) 실패");
		}
	}
}
