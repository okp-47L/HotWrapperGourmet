<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/account/general.css" rel="stylesheet"/>
<title>管理者削除</title>
<%
String id =request.getParameter("loginId");
%>


</head>
<body>
<%@include file="../menu_bar.jsp" %>

<div class="container">

<form action=../account/AdminDelete.action method="post">

<p>本当に削除しますか？
<%= id %></p>

<input type="hidden" name="loginId" value=<%=id %>> 
<input type="submit" value="はい" />  <button type="button" onclick="history.back()">戻る</button>
</form>
<br>
<a href="../TOP.jsp">TOPへ戻る</a>

</div>

</body>
</html>