<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function flushImg(){
		document.getElementById("codeImg").src="/TKM/CreateCodeServlet?"+Math.random();
	}
</script>
<body>
<%
	Cookie [] cks=request.getCookies();
	if(cks!=null){
		for(Cookie ck:cks){
			if(ck.getName().equals("userName")){
				String ckSavename=ck.getValue();
				request.setAttribute("saveName", ckSavename);
			}
			if(ck.getName().equals("pwd")){
				request.setAttribute("savePwd", ck.getValue());
			}
		}
	}
%>
	<form action="/TKM/LoginServlet" method="post">
	用户名:<input type="text" name="userName" value="${saveName}"><br/>
	密码:<input type="password" name="pwd" value="${savePwd}"><br/>
	请输入验证码<input type="text" name="code"><img alt="验证码" src="/TKM/CreateCodeServlet" onclick="flushImg()" id="codeImg">
	<input type="checkbox" name="rememberUser" >记住用户名和密码<br/>
	<input type="submit" value="登录">
	</form>

</body>
</html>