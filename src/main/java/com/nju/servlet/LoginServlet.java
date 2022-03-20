package com.nju.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nju.service.UserService;
import com.nju.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName= request.getParameter("userName");
		String password= request.getParameter("pwd");
		String inputCode=request.getParameter("code");
		String choiceStatus=request.getParameter("rememberUser");
		String createCode=request.getSession().getAttribute("code").toString();
		UserService us=new UserServiceImpl();
		if(inputCode.equals(createCode)) {
			if(us.login(userName,password)) {
				//cookie默认是不保存的，关闭浏览器就会消失
				if(choiceStatus!=null) {
					Cookie userNameCookie=new Cookie("userName",userName);
					Cookie pwdCookie=new Cookie("pwd",password);
					pwdCookie.setMaxAge(60);
					response.addCookie(userNameCookie);
					response.addCookie(pwdCookie);
				}
				request.getSession().setAttribute("uName", userName);
				response.sendRedirect("/TKM/GetAllHeroAndFuzzyQueryServlet");
			}
			else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
