<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tool.ReviewStar" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/style_review.css"/>
<head>
<meta charset="UTF-8">
<title>店舗口コミ一覧</title>
</head>
<style>
	#grade1{
		color:#fd951e
	}
	
	#grade2{
		color:#cccccc
	}
</style>
<body>
<%@include file="../menu_bar.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!--  エラーメッセージの表示 -->
<c:if test="${not empty errors}">
<h3><div class="error">⚠️${error}</div></h3>
</c:if>

<h2 class="heading-33">
    <span>${storeInfo.storeName } の口コミ一覧</span>
</h2>

<c:forEach var="reviewInfo" items="${reviewList}">
<button class="button-29" type=“button” onclick="location.href='ReviewInfo.action?reviewCode=${reviewInfo.reviewCode }'">
	<p>ニックネーム：${reviewInfo.name}  投稿日：${reviewInfo.date}  
	評価：
	<span id="grade1">
	<c:forEach var="star" begin="1" end="${ReviewStar.reviewStarGrade(reviewInfo.reviewGrade) }">
	★
	</c:forEach>
	</span>
	<span id="grade2">
	<c:forEach var="star" begin="${ReviewStar.reviewStarGrade(reviewInfo.reviewGrade) + 1}" end="5">
	★
	</c:forEach>
	</span>
	${reviewInfo.reviewGrade}
</button><br>
</c:forEach>

<div class="btn">
<button type="button" onclick="location.href='../store/store-info.jsp'">店舗情報へ戻る</button>
</div>
</body>
</html>