<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录成功</title>
</head>
<!-- 
EL表达式
隐式对象${对象名.属性名}
pageScope<requestScope<sessionScope<applicationScope
 -->
<body>
恭喜你登录成功
${uName}
</body>
</html>