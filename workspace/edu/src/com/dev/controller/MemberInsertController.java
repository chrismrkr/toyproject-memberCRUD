package com.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dto.MemberDTO;
import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberInsertController implements Controller {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("Insert Controller 호출");
		
		// 1.1 유효성 검증 -> 공백값 체크
		if(request.getParameter("id").isEmpty() || request.getParameter("pwd").isEmpty() || 
				request.getParameter("email").isEmpty() || request.getParameter("name").isEmpty()) {	
			request.setAttribute("error", "값을 모두 입력해주세요.");
			HttpUtil.forward(request, response, "/memberInsert.jsp");
			return;
		}
		
		
		// 1.2 유효성 검증 -> ID 중복 체크 
		if(isExisted(request.getParameter("id"))) {
			request.setAttribute("error", "이미 존재하는 ID입니다.");
			HttpUtil.forward(request, response, "/memberInsert.jsp");
			return;
		}
		
		
		// 2. 저장 Dto 생성
		MemberDTO memberDto = getNewMember(request);
		
		// 3. VO 생성
		MemberVO memberVO = new MemberVO(memberDto);
		
		// 4. member 등록
		MemberService.getInstance().memberInsert(memberVO);
		
		// 5. rendering output view
		request.setAttribute("id", memberVO.getId()); // 필터링을 위한 세션 생성?
		HttpUtil.forward(request, response, "/result/memberInsertOutput.jsp");
		
		return;
	}
	
	private boolean isExisted(String id) {
		return false;
	}
	
	private MemberDTO getNewMember(HttpServletRequest req) {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		return new MemberDTO(id, pwd, name, email);
	}
}
