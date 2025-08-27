<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/account/general_2.css" rel="stylesheet"/>
<title>管理者一覧</title>
</head>
<body>
<%@include file="../menu_bar.jsp" %>

<div class="container">

<form action=../superadmin/delete_check.jsp method="post">
	<h2>管理者一覧</h2><br>
	<c:forEach var="a" items="${list}">
	<p>	${a.loginId}:${a.name}　
	<button type="submit" name="loginId" value="${a.loginId}" >削除</button></p> </br>
	</c:forEach>
	</form>

</div>	
	
</body>
</html>