package com.nju.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nju.entity.Hero;
import com.nju.service.HeroService;
import com.nju.service.impl.HeroServiceImpl;
import com.nju.util.FileNameUtil;
@WebServlet("/UpdateOrAddHeroByServlet")
@MultipartConfig
public class UpdateOrAddHeroByServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ʹ��ͬһ����������Ӻ��޸ģ�ͨ��hid�Ƿ�Ϊ�ս����ж�
		Part part=request.getPart("photo");
		String imgPath="";
		if(part.getSubmittedFileName().length()>0) {
			//�����ֱ��浽���ݿ�
			imgPath=FileNameUtil.getNewFileName(part.getSubmittedFileName());
			part.write("D:\\Tomcat\\webapps\\upload\\"+imgPath);
		}		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String hName=request.getParameter("hname");
		String hBornDate=request.getParameter("hborndate");
		Date date=null;
		try {
			date=sdf.parse(hBornDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		HeroService heroService=new HeroServiceImpl();
		String hidStr=request.getParameter("hid");
		int result=0;
		if(!"".equals(hidStr)) {
			//�ǿ��ַ�����ʾhid��ֵ�������޸�
			int hid=Integer.parseInt(hidStr);
			if(imgPath.equals("")) {
				imgPath=heroService.getHeroImgPath(hid);
			}
			Hero hero=new Hero(hid,hName,date,imgPath);
			result=heroService.updateHeroByHid(hero);
		}
		else{
			Hero hero= new Hero(hName,date,imgPath);
			result=heroService.addHero(hero);
		}
		if(result==1) {
		response.sendRedirect("/TKM/GetAllHeroAndFuzzyQueryServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
