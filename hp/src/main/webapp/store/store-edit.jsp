<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tool.Convert" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/store/style_store_edit.css" />
<meta charset="UTF-8">
<title>店舗編集画面</title>
</head>
<body>

<%@include file="../menu_bar.jsp" %>

	<%@taglib prefix="c" uri="jakarta.tags.core" %>
	<h2 class="mainTitle">店舗編集</h2>
	<c:if test="${not empty errors}">
    <c:forEach var="e" items="${errors}">
      ${e}<br>
    </c:forEach>
	</c:if>
	<form action="StoreEditConfirm.action" method="post" enctype="multipart/form-data">
	<div class="wrapper">
	<div class="txt">
	<p><label class="title" for="id">店名</label></p>
	<p><input type="text" class="textStoreName" value="${storeKeepInfo.storeName }" name="storeName" pattern =".*\S+.*" maxlength="64" placeholder="64文字まで" required></p>
	
	<p><label class="title" for="id">店舗説明</label></p>
	<p><textarea name="storeExplain" placeholder="512文字まで" maxlength="512" resize:none; required>${storeKeepInfo.storeExplain }</textarea></p>
	
	<p><label class="title" for="id">住所</label></p>
	<p><input type="text" class="textAddress" value="${storeKeepInfo.address }" name="address" pattern =".*\S+.*" maxlength="64" placeholder="64文字まで" required></p>
	
	<p><label class="title" for="id">開店時間（hh:mm）</label></p>
	<p><input type="time" value="${storeKeepInfo.openTime }" name="openTime"></p>
	
	<p><label class="title" for="id">閉店時間（hh:mm）</label></p>
	<p><input type="time" value="${storeKeepInfo.closeTime}" name="closeTime"></p>
	
	<p><label class="title" for="id">電話番号</label></p>
	<p><input type="text" value="${storeKeepInfo.isdn }" name="isdn" pattern="\d{2,4}-\d{2,4}-\d{3,4}" required></p>
	
	<p><label class="title" for="id">定休日（複数選択可）</label></p>
	<p>
		<input type="checkbox" name="holiday" value="1" id="check1">日
		<input type="checkbox" name="holiday" value="2" id="check2">月
		<input type="checkbox" name="holiday" value="3" id="check3">火
		<input type="checkbox" name="holiday" value="4" id="check4">水
		<input type="checkbox" name="holiday" value="5" id="check5">木
		<input type="checkbox" name="holiday" value="6" id="check6">金
		<input type="checkbox" name="holiday" value="7" id="check7">土
	</p>
	
	<p><label class="title" for="id">ジャンル</label></p>
	<p>
		<select name="genre" id="genre">
		<option value="1">和食</option>
		<option value="2">洋食</option>
		<option value="3">丼</option>
		<option value="4">麺類</option>
		<option value="5">カレー</option>
		<option value="6">ベーカリー</option>
		<option value="7">ファストフード</option>
		<option value="8">焼肉</option>
		<option value="9">海鮮</option>
		<option value="10">その他</option>
		</select>
	</p>
	
	<p><label class="title" for="id">画像選択</label></p>
	<p>
	現在の画像　変更しない<input type="radio" name="image" value="${storeInfo.storeImage}" checked><br>
	<img src="${storeInfo.storeImage }" width="500" height="300" alt="Not Image"><br>
	</p>
	
	<p><input type="radio" name="image" value="0">
		画像の変更<br>
		<input type="file" name="file" id="inputFile"/>
	</p>
	
	<table>
	<tr>
	<td><p><input type="submit" value="確認"></p></td>
	<td><p><button type="button" onclick="location.href='store-info.jsp'">店舗詳細へ戻る</button></p></td>
	</tr>
	</table>
	</div>
	</div>
	</form>
	<script>
		let selectElement = document.getElementById('genre');
		let options = selectElement.options;
		options[${storeKeepInfo.genre} - 1].selected = true;

		let checkElement1 = document.getElementById('check1');
		let checkElement2 = document.getElementById('check2');
		let checkElement3 = document.getElementById('check3');
		let checkElement4 = document.getElementById('check4');
		let checkElement5 = document.getElementById('check5');
		let checkElement6 = document.getElementById('check6');
		let checkElement7 = document.getElementById('check7');

		var num = ${storeKeepInfo.regularHoliday};
		var s = String(num);
		console.log(num);
		for (let i = 0; i < s.length; i++){
			switch (s.charAt(i)){
				case '1':
					checkElement1.checked = true;
					break;
				case '2':
					checkElement2.checked = true;
					break;
				case '3':
					checkElement3.checked = true;
					break;
				case '4':
					checkElement4.checked = true;
					break;
				case '5':
					checkElement5.checked = true;
					break;
				case '6':
					checkElement6.checked = true;
					break;
				case '7':
					checkElement7.checked = true;
					break;
			}
		}
	</script>
</body>
</html>