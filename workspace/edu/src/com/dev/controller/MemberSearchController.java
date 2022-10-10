package com.dev.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 유효성 검증
		 * 		존재하지 않는 ID인지 아닌지 확인하기
		 * 2. 존재하면 SELECT 쿼리 후, MemberVO 반환
		 */
		String job = request.getParameter("job");
		String path = null;
		if(job.equals("search")) {
			path = "/result/memberSearchOutput.jsp";
		}
		if(job.equals("update")) {
			path = "/memberUpdate.jsp";
		}
		if(job.equals("delete")) {
			path = "/memberDelete.jsp";
		}
		
		
		MemberService service = MemberService.getInstance();
		MemberVO member = service.memberSearch(request.getParameter("id"));		
		
		if(member != null) {
			request.setAttribute("member", member);
		}
			
		else {
			request.setAttribute("message", "검색된 정보가 없습니다.");
		}
		
		
		HttpUtil.forward(request, response, path);
		return;
	}
	

}
