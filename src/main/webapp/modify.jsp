<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/TKM/UpdateOrAddHeroByServlet" method="post" enctype="multipart/form-data">
	<input type="text" name="hid" value="${h.hid}" readonly="readonly" hidden="hidden">
	大名:<input type="text" name="hname" value="${h.hname}"><br/>
	生辰:<input type="date" name="hborndate" value="${h.hborndate}"><br/>
	请选择头像:<input type="file" name="photo">
	<img alt="显示不了" src="http://localhost:8081/upload/${h.imgpath}" style="width:20px;height:20px">
	<input type="submit" value="提交">
	</form>

</body>
</html>