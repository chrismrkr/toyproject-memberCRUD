package com.dev.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController -> singleTon
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String charset = null;
	private final Map<String, Controller> controllerList = new HashMap<>();
	
	
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		charset = servletConfig.getInitParameter("charset");
		
		/* 컨트롤러 등록 */
		controllerList.put("/memberDelete.do", new MemberDeleteController());
		controllerList.put("/memberInsert.do", new MemberInsertController());
		controllerList.put("/memberList.do", new MemberListController());
		controllerList.put("/memberSearch.do", new MemberSearchController());
		controllerList.put("/memberUpdate.do", new MemberUpdateController());
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Front Controller 호출");
		
		request.setCharacterEncoding(charset);
		String path = request.getRequestURI().substring(request.getContextPath().length());
		
		// URL에 맞는 Controller 호출
		Controller mainController = controllerList.get(path);
		mainController.execute(request, response);
	}
	
}
