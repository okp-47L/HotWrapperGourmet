<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<title>店舗口コミ一覧</title>
</head>
<%@include file="../menu_bar.jsp" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!--  エラーメッセージの表示 -->
<c:if test="${not empty errors}">
<h3><div class="error">⚠️${error}</div></h3>
</c:if>

<p>評価を選択してください</p>
<form action="Search.action" method="post">
<h3>評価</h3>
	<select name="grade">

		<c:forEach var="i" begin="1" end="5">
			<option value="${i}">${i}</option>
		</c:forEach>
	</select>
<input type="submit" value="検索">
</form>
<hr>

<table style="border-collapse:seprate;border-spacing:10px;">
<c:forEach var="storeInfo" items="${reviewList}">
	<tr>
	<td>店名：${storeInfo.storeName}</td>
	<td><img src="../store/image/${storeInfo.storeImage}" height="64"></td>
	<td>${storeInfo.storeGrade}</td>
	<td><a href="StoreInfo.action?storeCode=${storeInfo.storeCode}">詳細</a></td>
	</tr>
</c:forEach>

</table>
</form>

</body>
</html>