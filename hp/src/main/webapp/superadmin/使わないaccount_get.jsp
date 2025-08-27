<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../menu_bar.jsp" %>

<form action=../account/AllGet.action method="post">
		<input type="radio" name="role" value=1>管理者
		<input type="radio" name="role" value=2>利用者
		
			<input type="submit" value="表示"></form>
</body>
</html>