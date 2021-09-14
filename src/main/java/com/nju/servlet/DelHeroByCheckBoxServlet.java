package com.nju.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nju.service.HeroService;
import com.nju.service.impl.HeroServiceImpl;
@WebServlet("/DelHeroByCheckBoxServlet")
public class DelHeroByCheckBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HeroService heroService=new HeroServiceImpl();
		String[] hidsStr=request.getParameter("hids").split(",");
		int count=0;
		for(int i=0;i<hidsStr.length;i++) {
			int hid=Integer.parseInt(hidsStr[i]);
			count+=heroService.delHeroByHid(hid);
		}
		if(count==hidsStr.length) {
			response.sendRedirect("/TKM/GetAllHeroAndFuzzyQueryServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
