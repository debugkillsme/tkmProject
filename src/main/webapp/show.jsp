<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.nju.entity.Hero" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎你！</title>
</head>

<body style="background: url(tkmbackground.jpg ); background-size:100%,100% ; background-attachment: fixed ">	
<p>你好欢迎来到你的界面</p>

${uName}<br>
<a href="/TKM/modify.jsp">添加</a>
<hr>
<form action="/TKM/GetAllHeroAndFuzzyQueryServlet" method="post">
请输入查找名称<input type="text" name="heroName">

<input type="submit" value="查询">
</form>
<input type="button" value="批量删除" onclick="delHero()">
<hr/>
<script>
	var checkHero = document.getElementsByName("checkHero");
	function checkAll(){
		var allCheck=document.getElementById("checkAll");
		for(var i=0;i<checkHero.length;i++){
			if(allCheck.checked==true){
				checkHero[i].checked=true;
			}else{
				checkHero[i].checked=false;
			}
		}
	}
	
	function delHero(){
		var hids=new Array();
		var j=0;
		for(var i=0;i<checkHero.length;i++){
			if(checkHero[i].checked==true){
				hids[j]=checkHero[j].value;
				j++;
			}
		}
		if(hids.length>0){
			//跳转到删除的控制器
			if(confirm("是否确定删除所选内容？"))
				location.href="/TKM/DelHeroByCheckBoxServlet?hids="+hids;
		}
		else{
			alert("请选择要删除的内容");
		}
	}
</script>

<table style="text-align:center;">
	<tr>
		<td><input type="checkBox" id="checkAll" onclick="checkAll()"></td>
		<td>编号</td>
		<td>大名</td>
		<td>生辰</td>
	</tr>
	<c:forEach items="${herolist}" var="hero">
	<tr>
		<td><input type="checkBox" name="checkHero" value="${hero.hid}"></td>
		<td>${hero.hid}</td>
		<td>${hero.hname}</td>
		<td>${hero.hborndate}</td>
		<td><img alt="" src="http://localhost:8081/upload/${hero.imgpath}" style="width:100px;height:100px" ></td>
		<td><a href="/TKM/GetHeroByHidServlet?hid=${hero.hid}">修改</a></td>
		<td><a href="/TKM/DelHeroByHidServlet?hid=${hero.hid}" onclick="return confirm('要删除嘛')">删除</a></td>
	</tr>
	</c:forEach>
	<tr>
	<td>一共${dataCount}条数据，共${pageCount}页，当前第${pageNo}页</td>
	</tr>
	
</table>
<!-- 当前页码大于1的情况下才显示首页和上一页 -->
	<c:if test="${pageNo>1}">
		<a href="/TKM/GetAllHeroAndFuzzyQueryServlet?pageNo=1">首页</a>
		<a href="/TKM/GetAllHeroAndFuzzyQueryServlet?pageNo=${pageNo-1}">上一页</a>
	</c:if>
	<c:if test="${pageNo<pageCount}">
		<a href="/TKM/GetAllHeroAndFuzzyQueryServlet?pageNo=${pageNo+1}">下一页</a>
		<a href="/TKM/GetAllHeroAndFuzzyQueryServlet?pageNo=${pageCount}">尾页</a>
	</c:if>

</body>
</html>