package com.iu.main.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMethodMappingNamingStrategy;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	//qna의 모든 기능은 로그인 한 사람만 가능하다
	//단, list는 제외
	//로그인이 안되어 있을 경우, 로그인 페이지로 이동
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		if(obj !=null) {
			return true;
		}else {
//			response.sendRedirect("../member/login");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
			request.setAttribute("message", "로그인이이 필요");
			request.setAttribute("url", "../member/login");
			view.forward(request, response);
			return false;
		}
		
	}
	
}
