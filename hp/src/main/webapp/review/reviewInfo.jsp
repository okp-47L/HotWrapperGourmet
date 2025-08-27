<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tool.Convert" %>
<%@ page import="tool.ReviewStar" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/style_review.css"/>
<head>
<meta charset="UTF-8">
<title>レビュー詳細画面</title>
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

<div class="info">
<c:set var="Role" value="${account.role}" />
	<p><label class="title">店名：</label>${reviewInfo.storeName }</p>
	<p><label class="title">ニックネーム：</label>${reviewInfo.name }</p>
	<p><label class="title">投稿日時：</label>${reviewInfo.date }</p>
	<p><label class="title">評価：</label>
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
	${reviewInfo.reviewGrade }</p>
	<p><label class="title">口コミ：</label><div class="content">${reviewInfo.reviewContent }</div></p>
	<div class="image"><img src="${reviewInfo.reviewImage}" alt="Not Image"></div>
</div>
<div class="btn">
<c:if test="${account.role==1}">
<button type="button" onclick="location.href='deleteReview.jsp'">削除</button>
</c:if>
<button type="button" onclick="location.href='reviewList.jsp'">口コミ一覧に戻る</button>
</div>
</body>
</html>