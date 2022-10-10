package com.dev.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.dev.dto.MemberDTO;
import com.dev.vo.MemberVO;
import java.sql.*;


/* Singleton Pattern */
public class MemberDAO {
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
	
	public ArrayList<MemberVO> searchAll() {
		System.out.println("memberDAO 호출");
		Connection conn = null;
		PreparedStatement stat = null;
		ArrayList<MemberVO> memberList = new ArrayList<>();
		
		try {
			conn = connect();
			stat = conn.prepareStatement("select * from test");
			
			ResultSet ret = stat.executeQuery();
			while(ret.next()) {
				MemberVO member = new MemberVO(
										new MemberDTO(
												ret.getString(2),
												ret.getString(3),
												ret.getString(4),
												ret.getString(5)));
				memberList.add(member);
			}
		}
		catch(SQLException e) {
			System.out.println("비정상적 SELECT QUERY 발생");
		}
		
		finally {
			if(stat != null) {
				try { stat.close(); }
				catch(Exception e) { }
			}
			if(conn != null) {
				try { conn.close(); }
				catch(Exception e) { }
			}
		}
		
		return memberList;
	}
	
	public void delete(String id) {
		System.out.println("memberDAO 호출(Delete)");
		

		Connection conn = null;
		PreparedStatement stat = null;
		
		try {
			conn = connect();
			stat = conn.prepareStatement(
					"delete test WHERE ID=?");
			
			stat.setString(1, id);

			
			int ret = stat.executeUpdate();
			System.out.println("ret: " + ret);
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("비정상적인 DELETE QUERY 발생");
		}
		
		finally { 
			if(stat != null) {
				try { stat.close(); }
				catch(Exception e) { }
			}
			if(conn != null) {
				try { conn.close(); }
				catch(Exception e) { }
			}
		}
	}
	
	public void update(MemberDTO dto) throws SQLException, ClassNotFoundException {
		System.out.println("memberDAO 호출(Update)");
		
		Connection conn = null;
		PreparedStatement stat = null;
		
		try {
			conn = connect();
			stat = conn.prepareStatement(
					"update test set pwd=?,NAME=?,EMAIL=? "
					+ "WHERE ID=?");
			
			System.out.println(dto.getPwd() + " " + dto.getName()+ " " + dto.getEmail() + " " + dto.getId());
			stat.setString(1, dto.getPwd());
			stat.setString(2, dto.getName());
			stat.setString(3, dto.getEmail());
			stat.setString(4, dto.getId());
			
			int ret = stat.executeUpdate();
			System.out.println("ret: " + ret);
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("비정상적인 Update QUERY 발생");
		}
		
		finally { 
			if(stat != null) {
				try { stat.close(); }
				catch(Exception e) { }
			}
			if(conn != null) {
				try { conn.close(); }
				catch(Exception e) { }
			}
		}
	}
	
	public void insert(MemberVO vo) throws SQLException, ClassNotFoundException {
		System.out.println("memberDAO 호출");
		
		Connection conn = null;
		PreparedStatement stat = null;
		
		try {
			conn = connect();
			stat = conn.prepareStatement("INSERT INTO TEST VALUES(?, ?, ?, ?, ?)");
		
			stat.setLong(1, vo.getKey());
			stat.setString(2, vo.getId());
			stat.setString(3, vo.getPwd());
			stat.setString(4, vo.getName());
			stat.setString(5, vo.getEmail());
			
			int ret = stat.executeUpdate();
			System.out.println("ret: " + ret);
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("비정상적인 INSERT QUERY 발생");
		}
		
		finally { 
			if(stat != null) {
				try { stat.close(); }
				catch(Exception e) { }
			}
			if(conn != null) {
				try { conn.close(); }
				catch(Exception e) { }
			}
		}
	}
	
	public MemberVO search(String id) {
		System.out.println("memberDAO 호출");
		
		Connection conn = null;
		PreparedStatement stat = null;
		MemberVO member = null;
		try {
			conn = connect();
			stat = conn.prepareStatement("select * from test where ID = ?");
			stat.setString(1, id);
			
			ResultSet ret = stat.executeQuery();
			if(ret.next()) {
				member = new MemberVO(new MemberDTO(ret.getString(2),
													ret.getString(3),
													ret.getString(4),
													ret.getString(5)));
			}
		}
		catch(SQLException e) {
			System.out.println("비정상적 SELECT QUERY 발생");
		}
		
		finally {
			if(stat != null) {
				try { stat.close(); }
				catch(Exception e) { }
			}
			if(conn != null) {
				try { conn.close(); }
				catch(Exception e) { }
			}
		}
		
		return member;
	}
	
	private Connection connect() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		}
		catch(ClassNotFoundException e) {
			System.out.println("DB Driver loading Fails");
		}
		
		catch(SQLException e) {
			System.out.println("DB Connection Fails");
		}
		return conn;
	}
}
