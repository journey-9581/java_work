package test.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.todo.dto.TodoDto;
import test.util.DBConnect;

public class TodoDao {
	
	//한개의 정보를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		
		try {
			DBConnect dbconn=new DBConnect();
			conn=dbconn.getConn();
			String sql="delete from todo where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
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
	public boolean update(TodoDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
			
		try {
			DBConnect dbconn=new DBConnect();
			conn=dbconn.getConn();
			String sql="update todo set content=?, regdate=?"
					+ " where num=?"; 
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getContent());
			pstmt.setString(2, dto.getRegdate());
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
	
	//한개의 정보를 저장하는 메소드
	public boolean insert(TodoDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		
		try {
			DBConnect dbconn=new DBConnect();
			conn=dbconn.getConn();
			String sql="insert into todo"
					+ " (num, content, regdate)"
					+ " values(todo_seq.NEXTVAL,?,sysdate)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getContent());
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
	public TodoDto select(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		TodoDto dto=null;
			
		try {
			conn=new DBConnect().getConn();
			String sql="select content, regdate from todo"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
				
			if(rs.next()){
				dto=new TodoDto();
				dto.setNum(num);
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
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
	public List<TodoDto> selectAll(){
		List<TodoDto> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			
		try {
			conn=new DBConnect().getConn();
			String sql="select num, content, "
					+ " to_char(regdate, 'yyyy\"년\" mm\"월\" dd\"일\" hh24:mi:ss')as regdate"
					+ " from todo"
					+ " order by num asc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TodoDto dto=new TodoDto();
				dto.setNum(rs.getInt("num"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
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