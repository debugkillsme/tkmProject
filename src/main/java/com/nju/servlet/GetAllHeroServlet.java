package com.nju.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nju.entity.Hero;
import com.nju.service.HeroService;
import com.nju.service.impl.HeroServiceImpl;


@WebServlet("/GetAllHeroServlet")
@Deprecated
public class GetAllHeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HeroService heroService=new HeroServiceImpl();
		List<Hero> list=heroService.getAllHero();
		//将展示的内容放到域中
		request.setAttribute("herolist", list);
		request.getRequestDispatcher("/show.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
