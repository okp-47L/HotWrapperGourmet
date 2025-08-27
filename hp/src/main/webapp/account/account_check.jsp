<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/account/user_check.css" rel="stylesheet"/>
<title>内容確認</title>
</head>
<body>
<%@include file="../menu_bar.jsp" %>



	<form action=AccountInsert.action method="post">
	<h4>入力内容をご確認ください。</h4>

<div class="container">
	
	<div class="row">
	<div class="label">ユーザーID</div>
	<div class="value">${loginId}</div>
	</div>
	
	<div class="row">
	<div class="label">パスワード</div>
	<div class="value">${hidePass}</div>
	</div>
	
	<div class="row">
	<div class="label">ニックネーム</div>
	<div class="value">${name}</div>
	</div>
	
	<div class="row">
	<div class="label">年齢</div>
	<div class="value">${age}</div>
	</div>
	
	</div>
	
	<div class="btn"><input type="submit" value="登録">

	</form>

	<form action=Revise.action method="post"><input type="submit" value="修正"></form>
	
	</div>
</body>
</html>