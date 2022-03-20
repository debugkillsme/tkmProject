<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
</head>
<script type="text/javascript">
/*
 * ajax Asynchronous Javascript and XML 异步的js和xml用于实现局部刷新和数据库交互提升用户体验
 */
 	var flag=false;
 	function checkName(){
		var userName=document.getElementById("userName").value;
		var spanNode=document.getElementById("userNameSpan");
		if(userName==null||userName==""){
			spanNode.innerHTML="名字不能为空";
			spanNode.style.color="red";
			flag=false;
		}else{
			//ajax核心对象XMLHttpRequest
			//1.创建核心对象
			var xhr=new XMLHttpRequest();
			//2.open方法的三个参数
			//第一个请求方式get post,第二个请求url,第三个是否为异步提交方式，默认为true
			url="/TKM/CheckUserNameServlet?userName="+userName;
			xhr.open("post",url,true);
			//3.发送请求send方法
			xhr.send();
			//4.使用核心对象的事件——状态改变事件，调用匿名函数执行一些操作
			//0.请求初始化 1.请求建立连接 2.请求发送完毕 3.请求接收完毕 4.响应完毕
			//HTTP状态码
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4 && xhr.status==200){
					//5.接收控制器返回给我们的响应
					var resText=xhr.responseText;
					//6.对接收到的内容做判断
					if(resText=="ok"){
						spanNode.innerHTML="√";
						spanNode.style.color="green";
						flag=true;
						
					}else{
						spanNode.innerHTML="用户名已经存在";
						spanNode.style.color="red";
						flag= false;
					}
				}
				
			}
		}
		function checkFlag(){
			if(flag){
				return true;
			}else{
				return false;
			}
		}
}
</script>
<body>
	<form action="/TKM/RegisterServlet" method="post" onsubmit="checkFlag()">
		请输入用户名:<input type="text" name="userName" id="userName" onblur="checkName()"><span id="userNameSpan"></span>
		请输入密码:<input type="password" name="pwd">
		<input type="submit" value="注册">
	</form>

</body>
</html>