package com.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 출력 뷰를 반환하는 객체 */
public class HttpUtil {
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) {
		try {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} catch(Exception e) {
			
		}
	}
}
