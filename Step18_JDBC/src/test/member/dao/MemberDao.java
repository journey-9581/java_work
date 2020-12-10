package test.member.dao;
/*
 * 회원정보(member 테이블)의 내용을
 * select
 * insert
 * update
 * delete
 * 작업을 할 객체를 생성할 클래스 설계하기
 * 
 * - 필요한 객체를 담을 지역변수를 선언하는 위치도 중요하다
 * - 필요한 객체를 생성하는 위치도 중요하다
 * 
 * Data Access Object (DAO)
 * 
 * - DB에 INSERT, UPDATE, DELETE, SELECT 작업을 수행하는 객체
 * - Table마다 하나의 DAO 혹은 주제(카테고리)마다 하나의 DAO를 작성하게 된다
 * - DAO를 만들기 위해서는 DTO 클래스를 미리 설계를 하고 만들어야 한다
 * - 주제(카테고리)에 관련된 DAO는 여러개의 Table의 join이 일어날 수도 있다
 *   따라서 하나의 Table당 하나의 DAO는 아닌 것이다
 *   예를 들어 사원 정보를 출력한다고 가정해보면
 *   emp, dept, salgrade 3개의 테이블이 join이 일어날 수도 있다
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import test.member.dto.MemberDto;
import test.util.DBConnect;

public class MemberDao {
	//모든 회원의 정보를 select해서 리턴하는 메소드
	public List<MemberDto> selectAll(){
		List<MemberDto> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=new DBConnect().getConn();
			String sql="select num, name, addr"
					+ " from member"
					+ " order by num asc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberDto dto=new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				list.add(dto);
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
		return list;
	}
	
	//회원 한명의 정보를 select해서 리턴하는 메소드
	public MemberDto select(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDto dto=null;
		
		try {
			conn=new DBConnect().getConn();
			String sql="select name, addr from member "
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				dto=new MemberDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){
				
			}
		}
		return dto;
	}
	
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
