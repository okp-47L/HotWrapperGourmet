<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tool.Convert" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/store/style_store_edit_confirmation.css"/>
<title>更新内容確認</title>
</head>
<body>
<%@include file="../menu_bar.jsp" %>

	<div class="wrapper">
	<h2 class="title">以下の内容で更新しますか？</h2>
	<div class="txt">
	<p><span>店名：</span>${storeKeepInfo.storeName }</p>
	<p><span>電話番号：</span>${storeKeepInfo.isdn }</p>
	<p><span>住所：</span>${storeKeepInfo.address }</p>
	<p><span>営業時間：</span>${Convert.convertTime(storeKeepInfo.openTime) }～${Convert.convertTime(storeKeepInfo.closeTime) }</p>
	<p><span>定休日：</span>${Convert.convertRegularHoliday(storeKeepInfo.regularHoliday) }</p>
	<p><span>ジャンル：</span>${Convert.convertGenre(storeKeepInfo.genre) }</p>
	<p><img src="${storeKeepInfo.storeImage }" width="500" height="300" alt="Not Image"></p>
	<p><span>店舗説明：</span>${storeKeepInfo.storeExplain }</p>
	<table>
	<tr>
	<td><button type="button" onclick="location.href='StoreUpdate.action'">更新</button></td>
	<td><button type="button" onclick="history.back()">戻る</button></td>
	</tr>
	</table>
	</div>
	</div>
</body>
</html>