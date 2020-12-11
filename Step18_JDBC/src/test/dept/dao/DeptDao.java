package test.dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dept.dto.DeptDto;
import test.member.dto.MemberDto;
import test.util.DBConnect;

public class DeptDao {
	
	//한개의 정보를 삭제하는 메소드
	public boolean delete(int deptno) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		
		try {
			DBConnect dbconn=new DBConnect();
			conn=dbconn.getConn();
			String sql="delete from dept where deptno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			flag=pstmt.executeUpdate();
			System.out.println("정보를 삭제했습니다");
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
	
	//한개의 정보를 수정하는 메소드
	public boolean update(DeptDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
			
		try {
			DBConnect dbconn=new DBConnect();
			conn=dbconn.getConn();
			String sql="update dept set dname=?, loc=?"
					+ " where deptno=?"; 
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getDname());
			pstmt.setString(2, dto.getLoc());
			pstmt.setInt(3, dto.getDeptno());
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
	
	//한개의 정보를 저장하는 메소드
	public boolean insert(DeptDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		
		try {
			DBConnect dbconn=new DBConnect();
			conn=dbconn.getConn();
			String sql="insert into dept"
					+ " (deptno, dname, loc)"
					+ " values(?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getDeptno());
			pstmt.setString(2, dto.getDname());
			pstmt.setString(3, dto.getLoc());
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
	
	//한개의 정보를 select해서 리턴하는 메소드
	public DeptDto select(int deptno) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		DeptDto dto=null;
			
		try {
			conn=new DBConnect().getConn();
			String sql="select dname, loc from dept"
					+ " where deptno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs=pstmt.executeQuery();
				
			if(rs.next()){
				dto=new DeptDto();
				dto.setDeptno(deptno);
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
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
	
	//모든 정보를 select해서 리턴하는 메소드
	public List<DeptDto> selectAll(){
		List<DeptDto> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			
		try {
			conn=new DBConnect().getConn();
			String sql="select deptno, dname, loc"
					+ " from dept"
					+ " order by deptno asc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				DeptDto dto=new DeptDto();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
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
}
