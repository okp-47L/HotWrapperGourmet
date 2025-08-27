<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/account/general.css" rel="stylesheet"/>
<title>ログアウト</title>
</head>
<body>
<%@include file="../menu_bar.jsp" %>

<div class="container">

<form action="Logout.action" method="post">
<p>ログアウトしますか？</p><br>
	<input type="submit" value="ログアウト" />
</form>

<a href="../TOP.jsp">TOPへ</a>

</div>

</body>
</html>