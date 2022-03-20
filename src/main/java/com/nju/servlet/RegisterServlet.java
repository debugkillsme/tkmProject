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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService =new UserServiceImpl();
		String userName = request.getParameter("userName");
		String password = request.getParameter("pwd");
		User user=new User(userName,password);
		if(userService.register(user)) {
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}else {
			request.getRequestDispatcher("/error.jsp").forward(request,response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
