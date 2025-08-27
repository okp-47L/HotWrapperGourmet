<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/style_review.css"/>
<head>
<meta charset="UTF-8">
<title>口コミ削除エラー</title>
</head>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="../menu_bar.jsp" %>

<!--  エラーメッセージの表示 -->
<c:if test="${not empty errors}">
<h3><div class="error">${error}</div></h3>
</c:if>

<h3>口コミ削除に失敗しました</h3>
<form action="../review/reviewInfo.jsp" method="post">
<div class="btn">
<input type="submit" value="口コミに戻る" class="back">
</div>

</form>
</body>
</html>