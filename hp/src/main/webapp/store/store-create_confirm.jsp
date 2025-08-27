<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tool.Convert" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗登録確認画面</title>
<link rel="stylesheet" type="text/css" href="../css/store/style_store_create_confirm.css"/>
</head>
<%@include file="../menu_bar.jsp" %>

<body>


<form action=StoreInsert.action method="post" style="text-align:center;">
<h2 class="mainTitle">以下の内容で登録しますか？</h2>
<div class="wrapper">
<div class="txt">
<p><span>店名：</span>${newStore.storeName }</p>
<p><span>電話番号：</span>${newStore.isdn }</p>
<p><span>住所：</span>${newStore.address }</p>
<p><span>営業時間：</span>${Convert.convertTime(newStore.openTime) }～${Convert.convertTime(newStore.closeTime) }</p>
<p><span>定休日：</span>${Convert.convertRegularHoliday(newStore.regularHoliday) }</p>
<p><span>ジャンル：</span>${Convert.convertGenre(newStore.genre) }</p>
<p><img src="${newStore.storeImage}" alt="image" width="500" height="300"></p>
<p><span>店舗説明：</span>${newStore.storeExplain}</p>
<table>
<tr>
	<td><p><input type="submit" value="登録"></p></td>
	<td><p><button type="button" onclick="history.back()">修正</button></p></td>
</form>
</tr>
</table>
</div>
</div>
</body>
</html>