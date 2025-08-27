<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/style_review.css"/>
<head>
<meta charset="UTF-8">
<title>店舗口コミ削除</title>
</head>
<body>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="../menu_bar.jsp" %>

<!--  エラーメッセージの表示 -->
<c:if test="${not empty errors}">
<h3><div class="error">${error}</div></h3>
</c:if>

<h3>口コミを削除しますか？</h3>
<div class="info">
	<p><label class="title">店名：</label>${reviewInfo.storeName }</p>
	<p><label class="title">ニックネーム：</label>${reviewInfo.name }</p>
	<p><label class="title">投稿日時：</label>${reviewInfo.date }</p>
	<p><label class="title">評価：</label>${reviewInfo.reviewGrade }</p>
	<p><label class="title">口コミ：</label><div class="content">${reviewInfo.reviewContent }</div></p>
	<div class="image">
	<img src="${reviewInfo.reviewImage}" alt="Not Image" width="500" height="300"><br>
	</div>
</div>
	<div class="btn">
	<button type="button" onclick="location.href='../review/deleteReview.action'">削除する</button>
	<button type="button" onclick="location.href='reviewInfo.jsp'">詳細に戻る</button>
	</div>

</body>
</html>