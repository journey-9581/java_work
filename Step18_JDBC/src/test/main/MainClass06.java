package test.main;
/*
 * Scanner 객체를 이용해서 검색할 회원의 번호를 입력 받아서
 * DB에서 select하고
 * 결과 값이 있으면 해당 회원의 정보를 콘솔창에 출력하고
 * 결과 값이 없으면 해당 회원은 존재 하지 않습니다 라고 출력되는 프로그래밍을 해보세요
 * 
 * 예)
 * 검색할 회원번호 입력:
 * 801
 * 801번 회원은 존재하지 않습니다
 * 
 * 예)
 * 검색할 회원번호 입력:
 * 850
 * 번호: 850, 이름: 톱캣, 주소: 건물 옥상
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import test.util.DBConnect;

public class MainClass06 {
	public static void main(String[] args) {
		
		//콘솔창 스캔
		Scanner scan=new Scanner(System.in);
		System.out.println("검색할 회원 정보 입력:");
		int num=scan.nextInt();
		
		//필요한 객체를 담은 지역변수 미리 만들기
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			DBConnect dbconn=new DBConnect();
			conn=dbconn.getConn();
			
			String sql="select num,name,addr from member where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			/*
			 * member table에서 num은 primary key 값이다
			 * 따라서 select 된 결과 row의 갯수는
			 * 0이거나 1이 된다
			 */
			
			if(rs.next()) {
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				System.out.println("번호:"+num+", 이름: "+name+", 주소:"+addr);
				}else {
				System.out.println(num+"번 회원은 존재하지 않습니다");
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
	}
}
