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
import com.nju.util.PageUtil;


@WebServlet("/GetAllHeroByPageServlet")
@Deprecated
public class GetAllHeroByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HeroService heroService=new HeroServiceImpl();
		String pageNoStr=request.getParameter("pageNo");
		if(pageNoStr==null) {
			pageNoStr="1";
		}
		int pageNo=Integer.parseInt(pageNoStr);
		int pageSize=2;//每页显示两条
		int dataCount=heroService.getHeroCount();
		PageUtil pageUtil=new PageUtil();
		pageUtil.setDataCount(dataCount);
		pageUtil.setPageNo(pageNo);
		pageUtil.setPageSize(pageSize);
		int pageCount=pageUtil.getPageCount();
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNo",pageNo);
		request.setAttribute("dataCount", dataCount);
		List<Hero> list=heroService.getAllHeroByPage(pageNo,pageSize);
		//将展示的内容放到域中
		request.setAttribute("herolist", list);
		request.getRequestDispatcher("/show.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
