package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.dto.MemberDTO;
import com.dev.service.MemberService;

public class MemberUpdateController implements Controller {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1.1 유효성 검증 -> 공백값 체크
		if(request.getParameter("id").isEmpty() || request.getParameter("pwd").isEmpty() || 
				request.getParameter("email").isEmpty() || request.getParameter("name").isEmpty()) {	
			request.setAttribute("error", "값을 모두 입력해주세요.");
			HttpUtil.forward(request, response, "/memberUpdate.jsp");
			return;
		}
		
		
		// 1.2 유효성 검증 -> ID 중복 체크 
		if(isExisted(request.getParameter("id"))) {
			request.setAttribute("error", "이미 존재하는 ID입니다.");
			HttpUtil.forward(request, response, "/memberUpdate.jsp");
			return;
		}
		
		
		// 2. 저장 Dto 생성
		MemberDTO memberDto = getNewMember(request);
		
		// 3. update 쿼리 수행
		MemberService service = MemberService.getInstance();
		service.memberUpdate(memberDto);
		
		// 4. 페이지 렌더링
		request.setAttribute("id", memberDto.getId());
		HttpUtil.forward(request, response, "/result/memberUpdateOutput.jsp");
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
