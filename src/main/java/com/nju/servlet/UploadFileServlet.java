package com.nju.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nju.util.FileNameUtil;
@WebServlet("/UploadFileServlet")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String userName=request.getParameter("userName");
		Part part=request.getPart("newfile");
		//上传图片到指定服务器
		//传输完成——显示；传输图片重名问题
		//随机生成字符串解决图片重名问题,再进行特殊字符串处理标记原有文件名
		String fileName=FileNameUtil.getNewFileName(part.getSubmittedFileName());
		//将图片放到Tomcat对应文件夹中
		part.write("D:\\Tomcat\\webapps\\upload"+"\\"+fileName);
		//连接数据库，将文件的路径保存到数据库中
		//在UpdateOrAddHero的servlet中
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
