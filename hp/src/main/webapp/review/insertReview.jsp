<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="../css/style_review.css"/>
<head>
<meta charset="UTF-8">
<title>店舗口コミ登録</title>
</head>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="../menu_bar.jsp" %>

<!--  エラーメッセージの表示 -->
<c:if test="${not empty errors}">
<h3><div class="error">${error}</div></h3>
</c:if>

<form action="Insert.action" method="post" enctype="multipart/form-data">

<div class="image"><img src="${storeInfo.storeImage }" alt="Not Image"></div>
<p><label class="title">店名：</label>${storeInfo.storeName }</p>
<p><label class="title">店舗説明：</label><div class="content">${storeInfo.storeExplain }</div></p>

<!-- 画像追加暫定処理 ここから -->
<p><label class="title">画像upload</label>
<input type="file" name="file" /></p>
<!-- ここまで -->

<p><label class="title">評価：</label>
	<select name="grade">
		<c:forEach var="i" begin="1" end="5">
			<option value="${i}">★${i}</option>
		</c:forEach>
	</select>
</p>
<p><label class="title">口コミ：</label>
<div class="review">
<textarea cols="80" rows="10" name="message" maxlength="500" placeholder="500文字以内で入力してください" required></textarea>
</div>

<div class="btn"><input type="submit" value="送信"></div>

</form>
</body>
</html>