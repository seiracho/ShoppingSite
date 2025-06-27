<%@page import="jp.co.aforce.beans.ItemBean"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/views/header.jsp" %>
    
    
    <%
    List<ItemBean> itemList=(List<ItemBean>)request.getAttribute("items");
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>商品一覧</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/items.css">
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet">
</head>
<body>
<h2>ITEM</h2>

<form class="search-form" action="searchitemservlet" method="post">

<select name="sort">
	<option value="">並び替え</option>
	<option value="price_asc">価格が安い順</option>
	<option value="price_desc">価格が高い順</option>
	<option value="name_asc">新着順</option>
</select>

<input type="text" name="keyword" placeholder="商品名">
<select name=brand_id>
	<option value="">All Brands</option>
	<option value="1">People Tree</option>
	<option value="2">Enter the E</option>
	<option value="3">KAPOK KNOT</option>
	<option value="4">oblekt</option>
	<option value="5">CASA FLINE</option>
	<option value="6">rrrrrrrrr</option>
	<option value="7">SOLIT!</option>
</select>
<select name="sdgs_category">
	<option value="">Favorite Values</option>
	<option value="#WFTO認証">＃WFTO認証※</option>
	<option value="#人動植物環境への配慮">＃人動植物環境への配慮※</option>
	<option value="#素材と生産背景の透明性">＃素材と生産背景の透明性</option>
	<option value="#GOTS認証">＃GOTS認証※</option>
	<option value="#CO2排出/水使用量削減">＃CO2排出/水使用量削減</option>
	<option value="#サステナブル素材">＃サステナブル素材</option>
</select>
<input type="submit" value="🔍">

<div class="explanation">
  <p>
    <strong>※WFTO認証</strong>
    活動の透明性が保証される世界フェアトレード団体であることを保証します。WFTOに加盟し、生産者の労働条件、賃金、児童労働、環境などに関して基準を満たしていることを認められた団体はWFTOマークを取得し、その後も、自己評価と相互評価、外部検証を通じて確認が行われています。
  </p>

  <p>
    <strong>※人動植物環境への配慮</strong>
    人、動植物、環境へ最大限配慮している団体/企業を指します。健全な価格設定、商品寿命の長期化、事業に使用する資源の影響への対処等、健全な事業取り組みを行っています。
  </p>

  <p>
    <strong>※GOTS認証</strong>
    オーガニック・テキスタイルの世界基準です。原材料がオーガニックであるだけでなく、生地の生産・加工や保管・流通のすべての過程で環境的・社会的な基準を満たした商品に認証が与えられます。
  </p>
</div>
</form>

<form action="itemlistservlet" method="post">
	<input type="submit" value="全商品一覧">
</form>
<div style="display: flex; flex-wrap: wrap; justify-content: center;">
	<% if(itemList !=null && !itemList.isEmpty()){ %>
		<% for(ItemBean item : itemList) { %>
			<div class="item-card">
			<a href="<%=request.getContextPath()%>/itemdetailservlet?item_id=<%=item.getItem_id()%>">
			<img src="<%=item.getImage_url() %>" alt="<%=item.getName() %>" class="item-img" width="150">
			<p><strong><%=item.getName() %></strong></p>
			<p>￥<%=item.getPrice() %>(税込)</p>
			</a>
			</div>
		<% } %>
	<% } else { %>
		<p>商品情報が見つかりませんでした。</p>
	<% } %>
</div>	
</body>
</html>