<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>
<%@include file="../menu_bar.jsp"%>

<!-- <link rel="stylesheet" type="text/css" href="../css/style_store.css" /> -->
<link rel="stylesheet" type="text/css" href="../css/store/style_store_create_in.css" />
<p>
<h2 class="mainTitle">
	店舗登録
</h2>
</p>
<c:if test="${not empty errors}">
	<c:forEach var="e" items="${errors}">
      ${e}<br>
	</c:forEach>
</c:if>

<form action="StoreCreateConfirm.action" method="post"
	enctype="multipart/form-data" style="text-align: left;">

	<!-- <div class="table-center"> -->
	<div class="wrapper">
	<div class="txt">

		<p>
			<label class="title" for="id">店名</label>
		</p>
		<p>
			<input type="text" class="textStoreName"
				name="storeName" value="${newStore.storeName}" placeholder="64文字まで"
				pattern=".*\S+.*" maxlength="64" required>
		</p>
		<p>
			<label class="title" for="id">店舗説明</label>
		</p>
		<p>
			<textarea name="storeExplain" placeholder="512文字まで" maxlength="512"
				resize:none; required>${newStore.storeExplain}</textarea>
		</p>
		<p>
			<label class="title" for="id">住所</label>
		</p>
		<p>
			<input type="text" class="textAddress"
				name="address" value="${newStore.address}" placeholder="64文字まで"
				pattern =".*\S+.*" maxlength="64" required>
		</p>
		<!--<body background="../upload/setmeal-arranged.jpeg">-->

		<p>
			<label class="title" for="id">開店時間 (hh:mm)</label>
		</p>
		<p>
			<input type="Time"
				name="openTime" required>
		</p>
		<p>
			<label class="title" for="id">閉店時間 (hh:mm)</label>
		</p>
		<p>
			<input type="Time"
				name="closeTime" required>
		</p>

		<p>
			<label class="title" for="id">電話番号</label>
		</p>
		<p>
			<input type="tel"
				name="isdn" value="${newStore.isdn}" placeholder="(xxxx-xxxx-xxxx)"
				pattern="\d{2,4}-\d{2,4}-\d{3,4}" required>
		</p>

		<!-- 定休日の表示をどうするかは要検討 -->
		<p>
			<label class="title" for="id">定休日（複数選択可）</label>
		</p>
		<p>
			<input type="checkbox"
				name="holiday" value="1">日 <input type="checkbox"
				name="holiday" value="2">月 <input type="checkbox"
				name="holiday" value="3">火 <input type="checkbox"
				name="holiday" value="4">水 <input type="checkbox"
				name="holiday" value="5">木 <input type="checkbox"
				name="holiday" value="6">金 <input type="checkbox"
				name="holiday" value="7">土
		</p>
		<p>
			<label class="title" for="id">ジャンル</label>
		</p>
		<p>
			<select name="genre">
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
		<!--				 画像追加暫定処理 ここから -->
		<p>
			<label class="title" for="id">画像選択</label>
		</p>
		<p>
			<input type="file" name="file" />
		</p>
		<!-- ここまで -->
		<table>
		<tr>
		<td><input type="submit" value="登録" /></td>
		</tr>
		</table>
		

	</div>
	</div>
	<!-- </div> -->


</form>
</body>
<%@include file="../footer.jsp"%>