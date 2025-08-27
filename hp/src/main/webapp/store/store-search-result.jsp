<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="tool.DrawStar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style_store.css"/>
<title>店舗検索画面</title>
<style>
	#grade1{
		color:#fd951e
	}
	
	#grade2{
		color:#cccccc
	}
</style>
</head>
<body>
	<%@include file="../menu_bar.jsp" %>
	<%@include file="store-search.jsp" %>
	検索結果：${list.size() }件
	<hr>
	<c:forEach var="store" items="${list }">
	<table>
	<tr>
	<td>
	<img src="../upload/FastFood.png" alt="Not Image" style="width: auto; height: 180px;">
	</td>
	<td>
	<p><a href="StoreInfo.action?storeCode=${store.storeCode }">${store.storeName}</a></p>
	<p>${store.address }</p>
	<p>
	<span id="grade1">
	<c:forEach var="star" begin="1" end="${DrawStar.drawStoreGrade(store.storeGrade) }">
	★
	</c:forEach>
	</span>
	<span id="grade2">
	<c:forEach var="star" begin="${DrawStar.drawStoreGrade(store.storeGrade) + 1}" end="5">
	★
	</c:forEach>
	</span>
	${store.storeGrade }
	</p>
	</td>
	</tr>
	</table>
	<hr>
	</c:forEach>
</body>
</html>

