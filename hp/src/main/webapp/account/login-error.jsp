<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<link href="../css/account/general.css" rel="stylesheet"/>
<title>ログイン失敗</title>
</head>
<body>
<%@include file="../menu_bar.jsp" %>

<div class="container">

<p>ユーザーIDまたはパスワードが違います。</p>

<button onclick="history.back()">修正</button>

</div>

<%@include file="../footer.jsp"%>