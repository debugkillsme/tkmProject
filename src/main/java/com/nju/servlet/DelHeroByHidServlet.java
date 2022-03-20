package com.nju.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nju.service.HeroService;
import com.nju.service.impl.HeroServiceImpl;

@WebServlet("/DelHeroByHidServlet")
public class DelHeroByHidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hid=Integer.parseInt(request.getParameter("hid"));
		HeroService heroService=new HeroServiceImpl();
		if(heroService.delHeroByHid(hid)==1) {
			response.sendRedirect("/TKM/getAllHeroAndFuzzyQueryServlet");
		}
		else {
			//¥ÌŒÛ“≥√Ê
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
