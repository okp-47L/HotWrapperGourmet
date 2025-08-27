<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/account/general.css" rel="stylesheet"/>
<title>退会確認</title>
</head>
<body>
<%@include file="../menu_bar.jsp" %>

<div class="container">

	<form action=ValidChange.action method="post">
	<p>アカウントを削除しますか？</p>

	
	
	<p>
		<input type="submit" value="退会する">
	</p>
</form>
	
	<a href="../TOP.jsp">TOPへ</a>
	
	</div>

</body>
</html>