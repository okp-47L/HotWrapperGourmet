<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="/HotWrapperGourmet/css/store/store_serch.css" rel="stylesheet"/>

<div class="serch">

<form class="serch" action="/HotWrapperGourmet/store/StoreSearch.action" method="post">
<!-- <input type="text" name="address" placeholder="所在地"> -->
<select name="address" id="address">
<option value="">選択してください(市区町村)</option>
<option value="千葉市中央区">千葉市中央区</option>
<option value="千葉市花見川区">千葉市花見川区</option>
<option value="千葉市稲毛区">千葉市稲毛区</option>
<option value="千葉市若葉区">千葉市若葉区</option>
<option value="千葉市緑区">千葉市緑区</option>
<option value="千葉市美浜区">千葉市美浜区</option>
<option value="銚子市">銚子市</option>
<option value="市川市">市川市</option>
<option value="船橋市">船橋市</option>
<option value="館山市">館山市</option>
<option value="木更津市">木更津市</option>
<option value="松戸市">松戸市</option>
<option value="野田市">野田市</option>
<option value="茂原市">茂原市</option>
<option value="成田市">成田市</option>
<option value="佐倉市">佐倉市</option>
<option value="東金市">東金市</option>
<option value="旭市">旭市</option>
<option value="習志野市">習志野市</option>
<option value="柏市">柏市</option>
<option value="勝浦市">勝浦市</option>
<option value="市原市">市原市</option>
<option value="流山市">流山市</option>
<option value="八千代市">八千代市</option>
<option value="我孫子市">我孫子市</option>
<option value="鴨川市">鴨川市</option>
<option value="鎌ヶ谷市">鎌ヶ谷市</option>
<option value="君津市">君津市</option>
<option value="富津市">富津市</option>
<option value="浦安市">浦安市</option>
<option value="四街道市">四街道市</option>
<option value="袖ヶ浦市">袖ヶ浦市</option>
<option value="八街市">八街市</option>
<option value="印西市">印西市</option>
<option value="白井市">白井市</option>
<option value="富里市">富里市</option>
<option value="南房総市">南房総市</option>
<option value="匝瑳市">匝瑳市</option>
<option value="香取市">香取市</option>
<option value="山武市">山武市</option>
<option value="いすみ市">いすみ市</option>
<option value="大網白里市">大網白里市</option>
<option value="酒々井町">酒々井町</option>
<option value="栄町">栄町</option>
<option value="神崎町">神崎町</option>
<option value="多古町">多古町</option>
<option value="東庄町">東庄町</option>
<option value="九十九里町">九十九里町</option>
<option value="芝山町">芝山町</option>
<option value="横芝光町">横芝光町</option>
<option value="一宮町">一宮町</option>
<option value="睦沢町">睦沢町</option>
<option value="長生村">長生村</option>
<option value="白子町">白子町</option>
<option value="長柄町">長柄町</option>
<option value="長南町">長南町</option>
<option value="大多喜町">大多喜町</option>
<option value="御宿町">御宿町</option>
<option value="鋸南町">鋸南町</option>
</select>
<select name="genre" id="genre">
<option value="0">選択してください(ジャンル)</option>
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
<select name="storeGrade" id="storeGrade">
<option value="0.0">選択してください(評価)</option>
<option value="1.0">評価1以上</option>
<option value="2.0">評価2以上</option>
<option value="3.0">評価3以上</option>
<option value="4.0">評価4以上</option>
<option value="5.0">評価5</option>
</select>
<input type="text" name="storeName" placeholder="店名を入力" value="${searchResults.storeName}">
<input type="submit" value="検索">
</form>
<script>
	let selectAddressElement = document.getElementById('address');
	let addressOptions = selectAddressElement.options;
	addressOptions[${addressNumber}].selected = true;
	

	let selectGenreElement = document.getElementById('genre');
	let genreOptions = selectGenreElement.options;
	genreOptions[${searchResults.genre}].selected = true;

	let selectStoreGradeElement = document.getElementById('storeGrade');
	let storeGradeOptions = selectStoreGradeElement.options;
	storeGradeOptions[${searchResults.storeGrade}].selected = true;
</script>

</div>