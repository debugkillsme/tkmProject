package com.nju.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nju.entity.Hero;
import com.nju.service.HeroService;
import com.nju.service.impl.HeroServiceImpl;

/**
 * Servlet implementation class GetHeroByHidServlet
 */
@WebServlet("/GetHeroByHidServlet")
public class GetHeroByHidServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hid=Integer.parseInt(request.getParameter("hid"));
		HeroService heroService=new HeroServiceImpl();
		Hero hero=heroService.getHeroByHid(hid);
		request.setAttribute("h", hero);
		request.getRequestDispatcher("/modify.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
