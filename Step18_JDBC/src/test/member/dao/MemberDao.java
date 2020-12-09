package test.member.dao;
/*
 * 회원정보(member 테이블)의 내용을
 * select
 * insert
 * update
 * delete
 * 작업을 할 객체를 생성할 클래스 설계하기
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import test.member.dto.MemberDto;
import test.util.DBConnect;

public class MemberDao {
	//회원 한명의 정보를 저장하는 메소드를 만들어 보세요
	//메소드명: insert, 리턴타입: 알아서, 메소드에 전달하는 인자의 타입: MemberDto
	public boolean insert(MemberDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
				DBConnect dbconn=new DBConnect();
				conn=dbconn.getConn();
				String sql="insert into member"
						+ " (num, name, addr)"
						+ " values(member_seq.NEXTVAL,?,?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, dto.getName());
				pstmt.setString(2, dto.getAddr());
				flag=pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				
			}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}   

	//회원 한명의 정보를 수정하는 메소드를 만들어보세요
	//메소드명: update, 리턴타입: 알아서, 메소드에 전달하는 인자의 타입: MemberDto
	public boolean update(MemberDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
				DBConnect dbconn=new DBConnect();
				conn=dbconn.getConn();
				String sql="update member set name=?, addr=?"
						+ " where num=?"; 
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, dto.getName());
				pstmt.setString(2, dto.getAddr());
				pstmt.setInt(3, dto.getNum());
				flag=pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				
			}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}
	
	//회원 한명의 정보를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		
		try {
			DBConnect dbconn=new DBConnect();
			conn=dbconn.getConn();
			String sql="delete from member where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			flag=pstmt.executeUpdate();
			System.out.println("회원 정보를 삭제했습니다");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
					
			}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}	
	}
}
