<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="../css/account/in.css" rel="stylesheet"/>
<meta charset="UTF-8">
<title>管理者追加</title>
</head>
<body>

<%@include file="../menu_bar.jsp" %>

	<form action=../account/IdCheck.action method="post">
		<h2>管理者追加</h2>
		
		<c:if test="${not empty errors}">
    <c:forEach var="e" items="${errors}">
    <div class="error">⚠️${e}<br></div>
    </c:forEach>
	</c:if>
	
		<div class="in">
		
		<p><label class="title" for="id">ユーザーID</label>
			<input type="text" id="id" name="loginId" required></p>
		
		<p><label class="title" for="pass">パスワード</label>
			<input type="password" id="pass" name="password" required></p>
		
		<p><label class="title" for="name">ニックネーム</label>
			<input type="text" id="name" name="name" required></p>
		
		<p><label class="title" for="age">年齢</label>
			<input type="number" id="age" name="age" required></p>
		
		</div>
		<div class="btn"><input type="submit" value="確認" /><input type="reset" value="リセット" /></div>
		
	</form>

</body>
</html>