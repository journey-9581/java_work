package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass03 {
	public static void main(String[] args) {
		//아래의 정보를 member 테이블에 저장하고자 한다
		String name="톰캣";
		String addr="건물 옥상";
				
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@14.63.164.99:1521:xe";
			conn=DriverManager.getConnection(url, "acorn01", "tiger01");
			System.out.println("Oracle DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//sql문을 대신 실행해주는 객체의 참조값을 담을 지역 변수
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			//미완성의 insert문
			String sql="insert into member "
					+ " (num, name, addr) "
					+ " values(member_seq.nextval, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			//?에 순서대로 값을 바인딩하기
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			//완성된 sql문을 수행하고 변화된 row의 갯수를 리턴 받는다
			flag=pstmt.executeUpdate();
			System.out.println("회원 정보를 저장했습니다");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				
			}
		}
		if(flag>0) {
			System.out.println("작업(INSERT) 성공");
		}else {
			System.out.println("작업(INSERT) 실패");
		}
	}
}

//String sql="delete from member where num=?"
//pstmt.setInt(1,100);
//flag=pstmt.executeUpdate();

//String sql="update member set name=?, addr=? where num=?"
//pstmt.setString(1, "kim");
//pstmt.setString(2, "nrg");
//pstmt.setInt(3,100);
//flag=pstmt.executeUpdate();