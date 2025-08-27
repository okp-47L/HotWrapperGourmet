<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tool.Convert" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<!-- <link rel="stylesheet" type="text/css" href="../css/style_store.css"/> -->
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" type="text/css" href="../css/style_store.css"/> -->
<link rel="stylesheet" type="text/css" href="../css/store/style_store_info.css"/>

<title>店舗詳細画面</title>
</head>
<body>
<%@include file="../menu_bar.jsp" %>


<c:set var="storeRole" value="${account.role}" />
<c:if test="${empty storeInfo.storeName}">

<c:redirect url="store-list.jsp"/>

</c:if>
	<div class="wrapper">
	<h2 class="title">店舗詳細</h2>
	<div class="txt">
	<p><span>店名：</span>${storeInfo.storeName }</p>
	<p><span>電話番号：</span>${storeInfo.isdn }</p>
	<p><span>住所：</span>${storeInfo.address }</p>
	<p><span>営業時間：</span>${Convert.convertTime(storeInfo.openTime) }～${Convert.convertTime(storeInfo.closeTime) }</p>
	<p><span>店舗評価：</span>${Convert.convertStoreGrade(storeInfo.storeGrade) }</p>
	<p><span>定休日：</span>${Convert.convertRegularHoliday(storeInfo.regularHoliday) }</p>
	<p><span>ジャンル：</span>${Convert.convertGenre(storeInfo.genre) }</p>
	<p><img src="storeInfo.storeImage" style="width: auto; height: 360px;" alt="Not Image">
	<p><span>店舗説明：</span>${storeInfo.storeExplain }</p>
	<table>
	<tr>
	<c:if test="${account.role==0 || account.role==1}">
	<td><button type="button" onclick="location.href='StoreEdit.action'">店舗編集</button></td>
	<td><button type="button" onclick="location.href='store-delete-check.jsp'">店舗削除</button></td>
	</c:if>
	<td><button type="button" onclick="location.href='../review/Search.action'">口コミ一覧</button></td>
	<c:if test="${account.role==2}">
	<td><button type="button" onclick="location.href='../review/insertReview.jsp'">口コミ投稿</button></td>
	</c:if>
	<td><button type="button" onclick="location.href='store-search-result.jsp'">店舗一覧へ戻る</button></td>
	</tr>
	</table>
	</div>
	</div>
</body>
</html>