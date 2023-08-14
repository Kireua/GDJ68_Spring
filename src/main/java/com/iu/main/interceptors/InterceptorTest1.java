package com.iu.main.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//@Component
public class InterceptorTest1 extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// return 이 true 면 Controller로 계속 진행 false면 거절 
		System.out.println("Controller 진입 전");
//		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views")
//		response.sendRedirect(null);
		return true;
	}
	


}
