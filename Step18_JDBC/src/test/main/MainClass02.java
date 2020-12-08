package test.main;
/*
 * 접속 ip 주소: 14.63.164.99
 * 아이디: acorn01
 * 비밀번호: tiger01
 * 
 * 위의 DB에 접속해서
 * emp 테이블의 내용 중에서 사원 번호, 사원 이름, 부서 번호, 급여
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass02 {
	public static void main(String[] args) {
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@14.63.164.99:1521:xe";
			conn=DriverManager.getConnection(url, "acorn01", "tiger01");
			System.out.println("Oracle DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select empno, ename, deptno "
					+ " from emp "
					+ " order by empno asc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
				int deptno=rs.getInt("deptno");
				System.out.println(empno+"|"+ename+"|"+deptno);
			}
		}catch(Exception e) {
			e.printStackTrace();
			}finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				}catch(Exception e) {
					
				}
		}
	}
}