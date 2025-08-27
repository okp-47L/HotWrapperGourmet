<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="../css/account/in.css" rel="stylesheet"/>
<meta charset="UTF-8">
<title>アカウント登録</title>
</head>
<body>

<%@include file="../menu_bar.jsp" %>

	<form action=IdCheck.action method="post">
		<h2>利用者登録</h2><br>
		
	<c:if test="${not empty errors}">
    <c:forEach var="e" items="${errors}">
    <div class="error">⚠️${e}<br></div>
    </c:forEach>
	</c:if>
	
	<div class="in">
		<p><label class="title" for="id">ユーザーID</label>
			<input type="text" id="id" name="loginId" value="${eloginId }" placeholder="半角英数:1-16字" maxlength="16" required></p>

		<p><label class="title" for="pass">パスワード</label>
			<input type="password" id="pass" name="password" value="${epassword }" placeholder="半角英数:4-16字" maxlength="16" required></p>
		
		<p><label class="title" for="name">ニックネーム</label>
			<input type="text" id="name" name="name" value="${ename }" placeholder="記号不可:1-16字" maxlength="16" required></p>
		
		<p><label class="title" for="age">年齢</label>
			<input type="number" id="age" name="age" value="${eage}" placeholder="数字のみ" required></p>
		
	</div>
		<div class="btn"><input type="submit" value="確認" /><input type="reset" value="リセット" /></div>
		
	
</form>


</body>
</html>