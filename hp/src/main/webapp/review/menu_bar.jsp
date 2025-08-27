<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/HotWrapperGourmet/css/menu_bar.css">
<title>メニュー</title>
</head>

<body>
	<div id="menu_a">

		<div class="link">
			<a href="/HotWrapperGourmet/TOP.jsp"> <img
				src="/HotWrapperGourmet/css/site_banner-toukavar-removebg-preview.png"
				width="300" height="40" alt="Hot Wrapper グルメ"></a>
		</div>

		<div class="title_a">"千葉県民による 千葉県民の為の グルメ情報サイト"</div>
		<br>

		<c:set var="Role" value="${account.role}" />

		<c:choose>
			<c:when test="${account==null}">

				<div class="menu1">
					<a href="/HotWrapperGourmet/TOP.jsp">HOME</a>
				</div>
				<div class="menu2">
					<a href="/HotWrapperGourmet/account/login-in.jsp">ログイン</a>
				</div>
				<div class="menu3">
					<a href="/HotWrapperGourmet/account/user_insert_in.jsp">ユーザー登録</a>
				</div>
				<div class="menu4">
					<a href="/HotWrapperGourmet/store/store-list.jsp">店舗情報検索</a>
				</div>

				<div class="menu0">ようこそ ゲスト さん！</div>
				<br>
			</c:when>

			<c:when test="${account.role==0}">
				<div class="menu1">
					<a href="/HotWrapperGourmet/TOP.jsp">HOME</a>
				</div>
				<div class="menu2">
					<a href="/HotWrapperGourmet/superadmin/admin_insert_in.jsp">管理者_新規登録</a>
				</div>
				<div class="menu3">
					<a href="/HotWrapperGourmet/store/store-create_in.jsp">新規店舗登録</a>

				</div>
				<div class="menu4">
					<a href="/HotWrapperGourmet/account/AllGet.action">管理者一覧</a>

				</div>
				<div class="menu5">
					<a href="/HotWrapperGourmet/store/store-list.jsp">店舗情報検索</a>

				</div>
				<div class="menu6">
					<a href="/HotWrapperGourmet/account/log_out.jsp">ログアウト</a>

				</div>

				<div class="menu0">-スーパー管理者-</div>

			</c:when>

			<c:when test="${account.role==1}">
				<div class="menu1">

					<a href="/HotWrapperGourmet/TOP.jsp">HOME</a>
				</div>
				<div class="menu2">
					<a href="/HotWrapperGourmet/account/log_out.jsp">ログアウト</a>
				</div>
				<div class="menu3">
					<a href="/HotWrapperGourmet/store/store-list.jsp">店舗情報検索</a>
				</div>
				<div class="menu4">
					<a href="/HotWrapperGourmet/store/store-create_in.jsp">新規店舗登録</a>
				</div>
				<div class="menu0">
					管理者:${account.name}</a>
				</div>
				<br>

			</c:when>

			<c:when test="${account.role==2}">
				<div class="menu1">
					<a href="/HotWrapperGourmet/TOP.jsp">HOME</a>
				</div>
				<div class="menu1">
					<a href="/HotWrapperGourmet/store/store-list.jsp">店舗情報検索</a>
				</div>
				<div class="menu2">
					<a href="/HotWrapperGourmet/account/log_out.jsp">ログアウト</a>
				</div>
				<div class="menu3">
					<a href="/HotWrapperGourmet/account/invalid-check.jsp">退会</a>
				</div>
				<div class="menu4">
					<a href="/HotWrapperGourmet/review/reviewList.jsp"></a>
				</div>
				<div class="menu0">こんにちは ${account.name} さん！</div>
			</c:when>


			<c:otherwise>?!</c:otherwise>

		</c:choose>
	</div>

</body>