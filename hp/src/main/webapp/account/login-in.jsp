<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../header.jsp"%>
    <link href="../css/account/in.css" rel="stylesheet"/>
    <meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<%@include file="../menu_bar.jsp" %>

    <form action="Login.action" method="post">

	<h2>     </h2><br>

<div class="in">

	<p><label class="title" for="id">ユーザーID</label>
	<input type="text" id="id" name="loginId" placeholder="半角英数:1-16字"></p>

	<p><label class="title" for="pass">パスワード</label>
	<input type="password" id="pass" name="password" placeholder="半角英数:4-16字"></p>
	
	</div>
		<div class="btn"><input type="submit" value="ログイン"><input type="reset" value="リセット" /></div>
	
	</form>
    

<%@include file="../footer.jsp"%>