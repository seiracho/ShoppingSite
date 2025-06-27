<%@page import="jp.co.aforce.beans.BrandBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.List" %>
 <%@include file="/views/header.jsp" %>
 
 <!-- Servletからのデータを受け取りbrandListに格納 -->
<%
	List<BrandBean> brandList=(List<BrandBean>)request.getAttribute("brands");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>ブランド一覧</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/brands.css">
	
	
</head>
<body>
<div class="main-text">
<h2>BRANDS</h2>
</div>
	
	
	<% if (brandList !=null && !brandList.isEmpty()) { %>
		<% for (BrandBean brand : brandList) { %>
			<div class="brand-card">
			<a href="#" class="brand-link" data-name="<%=brand.getBrand_name() %>" data-desc="<%=brand.getDescription() %>" data-img="<%=brand.getBrand_logo_url() %>">
			<p><strong><%=brand.getBrand_name() %></strong></p>
			<img src="<%=brand.getBrand_logo_url() %>" alt="<%=brand.getBrand_name() %>" class="brand-img" width="150">
			</a>
			</div>
		<% } %>
	<% } else { %>
		<p>ブランド情報が見つかりませんでした。</p>
	<% } %>
	
	<!-- モーダル表示部分 -->
<div id="brand-modal" class="modal">
  <div class="modal-content">
    <span class="close-button">&times;</span>
    <h2 id="modal-brand-name"></h2>
    <img id="modal-brand-img" src="" alt="ブランドロゴ" style="width: 100%; height: auto; max-height: 200px;" />
    <p id="modal-brand-desc"></p>
  </div>
</div>
	
	<script>
  // ブランド情報モーダル用
  document.querySelectorAll('.brand-link').forEach(link => {
    link.addEventListener('click', function(e) {
      e.preventDefault();  // リンクの本来の動作を止める

      // データ取得
      const name = this.dataset.name;
      const desc = this.dataset.desc;
      const img = this.dataset.img;

      // モーダルに表示
      document.getElementById('modal-brand-name').textContent = name;
      document.getElementById('modal-brand-desc').textContent = desc;
      document.getElementById('modal-brand-img').src = img;

      // モーダル表示
      document.getElementById('brand-modal').style.display = 'flex';
    });
  });

  // 閉じる処理
  document.querySelector('.close-button').addEventListener('click', function() {
    document.getElementById('brand-modal').style.display = 'none';
  });

  // モーダル外クリックで閉じる
  window.addEventListener('click', function(e) {
    const modal = document.getElementById('brand-modal');
    if (e.target === modal) {
      modal.style.display = 'none';
    }
  });
</script>
	
	
</body>
</html>