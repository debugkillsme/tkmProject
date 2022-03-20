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
		//�ϴ�ͼƬ��ָ��������
		//������ɡ�����ʾ������ͼƬ��������
		//��������ַ������ͼƬ��������,�ٽ��������ַ���������ԭ���ļ���
		String fileName=FileNameUtil.getNewFileName(part.getSubmittedFileName());
		//��ͼƬ�ŵ�Tomcat��Ӧ�ļ�����
		part.write("D:\\Tomcat\\webapps\\upload"+"\\"+fileName);
		//�������ݿ⣬���ļ���·�����浽���ݿ���
		//��UpdateOrAddHero��servlet��
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
