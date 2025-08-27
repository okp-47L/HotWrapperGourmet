<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style_store.css"/>
<title>店舗検索画面</title>
</head>
<body>
<%
	session.removeAttribute("searchResults");
	session.removeAttribute("addressNumber");
%>

<%@include file="../menu_bar.jsp" %>

<div class="serch">

<%@include file="store-search.jsp" %>

</div>

</body>
</html>