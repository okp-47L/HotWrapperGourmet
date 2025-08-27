<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/style_review.css"/>
<head>
<meta charset="UTF-8">
<title>店舗口コミ削除完了</title>
</head>
<%@include file="../menu_bar.jsp" %>

<h3>口コミを削除が成功しました</h3>

<form action="../review/reviewList.jsp" method="post">
<div class="btn">
<input type="submit" value="口コミ一覧に戻る" class="back">
</div>

</form>
</body>
</html>