<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホットラッパーグルメ-トップ</title>
<link rel="stylesheet" type="text/css" href="/HotWrapperGourmet//css/style_store.css"/>
<link href="css/top.css" rel="stylesheet"/>
</head>
<body>
<%@include file="menu_bar.jsp" %>

<%@include file="store/store-search.jsp" %>

<div class="store-list-container">

<h2 class="section-title">本日のおすすめ店</h2>
<p class="section-subtitle">今注目のグルメスポットをランダムにピックアップしました！</p>

</div>

<c:forEach var="view" items="${topview}">

<div class="S">
  <div class="Simage">
    <a href="store/StoreInfo.action?storeCode=${view.storeCode}" class="store-link">
      <img src="upload/FastFood.png" style="width: auto; height: 180px;" alt="No Image">
  </div>
  <div class="Sinfo">
    <div class="Sname"><p>${view.storeName}</p></div>
    <div class="Sexplain"><p>${view.storeExplain}</p></div>
    <div class="Sgrade">
  <p>
    <span class="stars" data-stars="${view.storeGrade >= 5 ? '★★★★★' : 
                                     view.storeGrade >= 4 ? '★★★★☆' :
                                     view.storeGrade >= 3 ? '★★★☆☆' :
                                     view.storeGrade >= 2 ? '★★☆☆☆' :
                                     view.storeGrade >= 1 ? '★☆☆☆☆' : '☆☆☆☆☆'}">
    </span>（${view.storeGrade}）
  </p>
</div>
    
  </div></a>
</div>

</c:forEach>

<c:set var="role" value="${account.role}" />

</body>
</html>