package com.dev.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import com.dev.dao.MemberDAO;
import com.dev.dto.MemberDTO;
import com.dev.vo.MemberVO;

/* SingleTon Pattern */
public class MemberService {		
	private MemberDAO dao;
	private MemberService() {
		this.dao = MemberDAO.getInstance();
	}
	
	private static MemberService instance = new MemberService();
	public static MemberService getInstance() {
		return instance;
	}
	
	public ArrayList<MemberVO> memberAllSearch() {
		System.out.println("memberService -> memberSearchAll 호출");
		ArrayList<MemberVO> ret = dao.searchAll();
		return ret;
	}
	
	public void memberDelete(String id) {
		System.out.println("memberService -> memberDelete 호출");
		dao.delete(id);
	}
	
	public void memberUpdate(MemberDTO dto) {
		System.out.println("memberService -> memberUpdate 호출");
		try { 
			dao.update(dto); 
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void memberInsert(MemberVO vo) {
		System.out.println("memberService -> memberInsert 호출");

		try {
			dao.insert(vo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public MemberVO memberSearch(String id) {
		System.out.println("memberService -> memberSearch 호출");
		MemberVO ret = dao.search(id);
		return ret;
	}
}
