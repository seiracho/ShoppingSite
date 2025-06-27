<%@page import="jp.co.aforce.beans.ItemBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	ItemBean itemBean=(ItemBean) request.getAttribute("itemBean");
if (itemBean == null) {
    out.println("<p style='color:red;'>エラー：商品情報が見つかりません</p>");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>ItemDetailPage</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/items.css">
</head>
<body>
	<a href="<%=request.getContextPath() %>/itemlistservlet">商品一覧に戻る</a>
	<% if (itemBean != null) {  %>
		<div class="itemDetail">
		<h3><%=itemBean.getName() %></h3>
		<p class="price"><strong><%=itemBean.getPrice() %>円</strong></p>
		<p class="description"><%=itemBean.getDescription() %></p>
		
		<div class="value-tags">
    <p><strong>VALUE:</strong></p>
    <%
    String[] tags = itemBean.getSdgs_category().split("[,、\\s]+");
    for(String tag : tags) {
      String className = "tag-default"; // デフォルト
      if (tag.contains("GOTS")) className = "tag-gots";
      else if (tag.contains("WFTO")) className = "tag-wfto";
      else if (tag.contains("動植物") || tag.contains("環境")) className = "tag-eco";
      else if (tag.contains("透明性")) className = "tag-transparent";
      else if (tag.contains("CO2") || tag.contains("水使用")) className = "tag-co2";
      else if (tag.contains("サステナブル")) className = "tag-sustainable";
  %>
    <span class="value-tag <%=className%>"><%=tag%></span>
  <% } %>
  </div>
  
	<!-- メイン画像 -->
<img id="mainImage"
     src="<%=request.getContextPath() + "/" + itemBean.getImage_url() %>"
     alt="メイン画像"
     style="width:400px; height:auto;">

<!-- サブ画像＋メイン画像を含む -->
<div class="thumbnail-container">
  <!-- 最初のメイン画像もサムネイルに表示する -->
  <img class="subImage"
       src="<%=request.getContextPath() + "/" + itemBean.getImage_url() %>"
       data-src="<%=request.getContextPath() + "/" + itemBean.getImage_url() %>"
       alt="メイン画像サムネイル"
       style="width:80px; height:auto; cursor:pointer; margin:5px;">

  <% String[] subImages = {
      itemBean.getSub_image1(),
      itemBean.getSub_image2(),
      itemBean.getSub_image3(),
      itemBean.getSub_image4()
  }; %>

  <% for(String img : subImages) {
      if(img != null && !img.trim().isEmpty() && !img.equalsIgnoreCase("null")) { %>
    <img class="subImage"
         src="<%=request.getContextPath() + "/" + img %>"
         data-src="<%=request.getContextPath() + "/" + img %>"
         alt="サブ画像"
         style="width:80px; height:auto; cursor:pointer; margin:5px;">
  <% }} %>
</div>


		
		<p>ブランド：<a href="<%=request.getContextPath()%>/brandlistservlet?brand_id=<%=itemBean.getBrand_id()%>">
    <%=itemBean.getBrand_name()%></a></p>
    
    <form action="<%=request.getContextPath()%>/cartservlet" method="post">
	<input type="hidden" name="item_id" value="<%=itemBean.getItem_id() %>">
	<input type="number" name="quantity" value="1" min="1">
	<input type="submit" name="action" value="カートに追加">
	</form>
		</div>
	<% } else { %>
			<p>商品情報の取得に失敗しました</p>
	<% } %>		


<script>
  window.addEventListener('DOMContentLoaded', () => {
    const mainImage = document.getElementById('mainImage');
    const subImages = document.querySelectorAll('.subImage');

    subImages.forEach(subImg => {
      subImg.addEventListener('click', () => {
        const newSrc = subImg.getAttribute('data-src');
        if (newSrc && newSrc.trim() !== '') {
          mainImage.src = newSrc;
        }
      });
    });
  });
</script>



</body>
</html>