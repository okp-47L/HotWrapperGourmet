<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<title>店舗口コミ入力確認</title>
</head>
<%@include file="../menu_bar.jsp" %>


<%
	String name = (String)session.getAttribute("name");
	String message = request.getParameter("message");
	String grade = request.getParameter("grade");
%>
<h3>店舗口コミ入力確認</h3><br>
<h2>以下の内容で口コミを登録しますか？</h2>
<p><strong>ニックネーム：</strong><%=name%></p>
<p><strong>口コミ内容：</strong><%=message%></p>
<p><strong>評価：</strong><%=grade%></p>

<form action="Insert.action" method="post">
<input type="hidden" name="message" value="<%=message%>">
<input type="hidden" name="grade" value="<%=grade%>">
<input type="submit" value="はい" class="yes">
</form>

<form action="../review/insertReview.jsp" method="post">
<input type="hidden" name="message" value="<%=message%>">
<input type="hidden" name="grade" value="<%=grade%>">
<input type="submit" value="いいえ" class="no">
</form>

</body>
</html>