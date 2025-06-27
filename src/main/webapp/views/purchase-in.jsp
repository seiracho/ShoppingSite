<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="jp.co.aforce.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
UserBean userBean=(UserBean)session.getAttribute("user");
if(userBean == null){
	response.sendRedirect(request.getContextPath()+"/views/login-in.jsp");
	return;
}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入手続き</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user-pages.css">

</head>
<body>
	<h1>購入手続きフォーム</h1>
	<h2>購入内容の確認</h2>
	<p></p>
	<p>下記の内容をご入力の上、お進みください</p>
	<div class="type-customer-ditail">
	<form action="<%=request.getContextPath()%>/purchaseservlet" method="post" onsubmit="return confirm('商品購入を確定しますか？');">
	氏名<input type="text" name="last_name" placeholder="姓" required>
	<input type="text" name="first_name" placeholder="名" required><br>
	メールアドレス<input type="text" name="mail_address" placeholder="aaa@gmail.com" required><br>
	郵便番号<input type="text" name="" placeholder="郵便番号" required><br>
	都道府県<input type="text" name="" required><br>
	住所<input type="text" name="address" placeholder="市区町村 番地 建物名" required><br>
	電話番号<input type="text" name="phone-number" required><br>
	<input type="checkbox" name="keep" value="次回のためこの情報を保存する">
	<!-- 支払い方法 -->
<select name="purchase_method">
  <option value="">選択してください</option>
  <option value="credit">クレジットカード</option>
  <option value="cod" >代金引換</option>
</select><br>
	<p>通常、注文確定日より5営業日以内にヤマト運輸にて発送いたします。<br>ご注文後の商品の交換／返品は原則受付けておりません。</p>
	<!-- 同意チェック -->
<input type="checkbox" name="agree" value="1" > 利用規約および個人情報保護方針に同意します
	<input type="submit" value="購入確定">
	</form>
	<a href="<%=request.getContextPath()%>/cartservlet">カートへ戻る</a>
	</div>
</body>
</html>