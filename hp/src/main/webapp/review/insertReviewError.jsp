<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/style_review.css"/>
<head>
<meta charset="UTF-8">
<title>口コミ登録エラー</title>
</head>
<%@include file="../menu_bar.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!--  エラーメッセージの表示 -->
<c:if test="${not empty errors}">
<h3><div class="error">${error}</div></h3>
</c:if>

<h3>口コミ登録に失敗しました</h3>
<form action="../review/insertReview.jsp" method="post">
<div class="btn"><input type="submit" value="口コミ登録に戻る" class="back"></div>
</form>

</body>
</html>