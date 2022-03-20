package com.nju.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nju.entity.Hero;
import com.nju.service.HeroService;
import com.nju.service.impl.HeroServiceImpl;
import com.nju.util.PageUtil;


@WebServlet("/GetAllHeroAndFuzzyQueryServlet")
public class GetAllHeroAndFuzzyQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HeroService heroService=new HeroServiceImpl();
		HttpSession session=request.getSession();
		int dataCount=0;
		String pageNoStr=request.getParameter("pageNo");
		int pageSize=3;//每页显示两条
		if(pageNoStr==null) {
			pageNoStr="1";
			session.setAttribute("heroNameCondition", null);
		}
		String heroName=request.getParameter("heroName");
		StringBuffer condition=new StringBuffer();
		if(!"".equals(heroName)&&heroName!=null) {
			condition.append(" and hname like '%"+heroName+"%'");
			//当代码进入这个判断条件，表示文本框已经存在内容，为了防止点击下一页不再根据之前条件显示内容，使用session作用域
			session.setAttribute("heroNameCondition", heroName);
		}
		else if(session.getAttribute("heroNameCondition")!=null) {
			heroName=session.getAttribute("heroNameCondition").toString();
			condition.append(" and hname like '%"+heroName+"%'");
			
		}
		int pageNo=Integer.parseInt(pageNoStr);
		
		dataCount=heroService.getHeroCountByCondition(condition);		
		//将展示的内容放到域中
		PageUtil pageUtil=new PageUtil();
		pageUtil.setDataCount(dataCount);
		pageUtil.setPageNo(pageNo);
		pageUtil.setPageSize(pageSize);
		int pageCount=pageUtil.getPageCount();
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNo",pageNo);
		request.setAttribute("dataCount", dataCount);
		List<Hero> list=heroService.getAllHeroAndFuzzyQuery(pageNo,pageSize,condition);
		//将展示的内容放到域中
		request.setAttribute("herolist", list);
		request.getRequestDispatcher("/show.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
