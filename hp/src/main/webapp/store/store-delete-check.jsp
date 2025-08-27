<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style_store.css"/>
<title>削除内容確認</title>
</head>
<body>
	<!-- <form action=StoreDelete.action method="post"> -->
<%@include file="../menu_bar.jsp" %>
<p>
		<b>店名:</b>${storeInfo.storeName }
	</p>
	<p>
		<b>住所:</b>${storeInfo.address }
	</p>
	<p>
		<b>ジャンル:</b>${storeInfo.genre }
	</p>
	<p>
		<b>店舗説明:</b>${storeInfo.storeGrade }
	</p>
	<p>
		<b>店舗説明:</b>${storeInfo.storeExplain }
	</p>
	

		<h4><b>以上の店舗を本当に削除してもよろしいですか？</b></h4>
	

		<button type="button" onclick="location.href='StoreDelete.action'">削除</button>
	
<!-- </form> -->

	<p><button onclick="history.back()">店舗詳細に戻る</button></p>

</body>
</html>