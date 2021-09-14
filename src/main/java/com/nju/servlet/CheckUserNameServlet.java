package com.nju.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nju.entity.User;
import com.nju.service.UserService;
import com.nju.service.impl.UserServiceImpl;

@WebServlet("/CheckUserNameServlet")
public class CheckUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		//Êý¾Ý¿â²éÑ¯
		UserService userService=new UserServiceImpl();
		User user=userService.getUserByUserName(userName);
		if(user!=null) {
			response.getWriter().print("error");
		}else {
			response.getWriter().print("ok");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
