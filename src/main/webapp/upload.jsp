<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 上传文件，提交方式必须为Post，encType为multipart/form-data -->
	<form action="/TKM/UploadFileServlet" enctype="multipart/form-data" method="post">
	用户名:<input type="text" name="userName"><br/>
	请选择头像:<input type="file" name="newfile"><br/>
	<input type="submit" value="提交">
	
	</form>
</body>
</html>