<%@page import="jp.co.aforce.beans.BrandBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="jp.co.aforce.beans.ItemBean"%>

<%
List<ItemBean> itemList = (List<ItemBean>) request.getAttribute("items");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報管理</title>
<link rel="stylesheet" href="/ShoppingSite/css/admin-item.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin-page.css">
</head>
<body>

<a href="<%=request.getContextPath()%>/views/admin-home.jsp">ホームへ戻る</a>

	<% if (itemList != null && !itemList.isEmpty()) { %>
	<% for (ItemBean item : itemList) { %>
	<div class="item-card">
		<p>商品名：<strong><%=item.getName()%></strong></p>
		<p>アイテムID:<%=item.getItem_id()%></p>
		<p>価格：<%=item.getPrice()%></p>
		<p>ブランドID:<%=item.getBrand_id()%></p>
		<p>在庫数：<%=item.getStock()%></p>
		<p>SDGsカテゴリー：<%=item.getSdgs_category()%></p>
		<p>商品説明：<%=item.getDescription()%></p>
		メイン画像：<img src="<%=item.getImage_url()%>" class="item-img" width="150">
	    サブ画像1：<img src="<%=item.getSub_image1()%>" class="item-img" width="150">
		サブ画像2：<img src="<%=item.getSub_image2()%>" class="item-img" width="150">
		サブ画像3：<img src="<%=item.getSub_image3()%>" class="item-img" width="150">
		サブ画像4：<img src="<%=item.getSub_image4()%>" class="item-img" width="150">
	
	<!-- 操作ボタン -->
	<button class="action-btn edit-btn"	onclick="openModal('editModal<%=item.getItem_id()%>')">編集</button>
	<button class="action-btn delete-btn" onclick="openModal('deleteModal<%=item.getItem_id()%>')">削除</button>
</div>

<!-- 編集モーダル -->
	<div id="editModal<%=item.getItem_id()%>" class="modal">
		<div class="modal-content">
			<span class="close-btn" onclick="closeModal('editModal<%=item.getItem_id()%>')">&times;</span>
			<h3>編集</h3>
			<form action="${pageContext.request.contextPath}/adminitemeditservlet" method="post" onsubmit="return confirm('商品情報更新を確定しますか？');">
				<input type="hidden" name="item_id" value="<%=item.getItem_id()%>">
				<label>商品名：<input type="text" name="name" value="<%=item.getName()%>" required></label>
				<label>価格：<input type="number" name="price" value="<%=item.getPrice()%>" required></label> 
				<label>ブランドID：
				  <select name="brand_id" required>
				    <option value="1" <%= item.getBrand_id() == 1 ? "selected" : "" %>>People Tree</option>
				    <option value="2" <%= item.getBrand_id() == 2 ? "selected" : "" %>>Enter the E</option>
				    <option value="3" <%= item.getBrand_id() == 3 ? "selected" : "" %>>KAPOK KNOT</option>
				    <option value="4" <%= item.getBrand_id() == 4 ? "selected" : "" %>>oblekt</option>
				    <option value="5" <%= item.getBrand_id() == 5 ? "selected" : "" %>>CASA FLINE</option>
				    <option value="6" <%= item.getBrand_id() == 6 ? "selected" : "" %>>rrrrrrrrr</option>
				    <option value="7" <%= item.getBrand_id() == 7 ? "selected" : "" %>>SOLIT!</option>
				  </select>
				</label>
				<label>在庫数：<input type="number" name="stock" value="<%=item.getStock()%>" required></label>
				<label>SDGsカテゴリー：<input type="text" name="sdgs_category" value="<%=item.getSdgs_category()%>" required></label>
				<label>商品説明：<input type="text" name="description" value="<%=item.getDescription()%>" required></label>
				<label>メイン画像：<input type="text" name="image_url" value="<%=item.getImage_url()%>" required></label> 
				<label>サブ画像1：<input type="text" name="sub_image1" value="<%=item.getSub_image1()%>"></label>
				<label>サブ画像2：<input type="text" name="sub_image2" value="<%=item.getSub_image2()%>"></label> 
				<label>サブ画像3：<input type="text" name="sub_image3" value="<%=item.getSub_image3()%>"></label>
				<label>サブ画像4：<input type="text" name="sub_image4" value="<%=item.getSub_image4()%>"></label>
				<button type="submit" class="action-btn edit-btn">更新する</button>
			</form>
		</div>
	</div>

	<!-- 削除モーダル -->
	<div id="deleteModal<%=item.getItem_id()%>" class="modal">
		<div class="modal-content">
			<span class="close-btn" onclick="closeModal('deleteModal<%=item.getItem_id()%>')">&times;</span>
			<h3>本当に削除しますか？</h3>
			<p>商品名：<%=item.getName()%></p>
			<form action="adminitemdeleteservlet" method="post" onsubmit="return confirm('商品削除を確定しますか？');">
				<input type="hidden" name="item_id" value="<%=item.getItem_id()%>">
				<button type="submit" class="action-btn delete-btn">削除する</button>
			</form>
		</div>
	</div>
	<% } %>
	<% } else { %>
	<p>商品情報が見つかりませんでした。</p>
	<% } %>

	<!-- 商品新規登録 -->
	<!-- サーバーに送る -->
	<form action="adminitemaddservlet" method="post" enctype="multipart/form-data"
	onsubmit="return confirm('登録を確定しますか？');">
		<input type="hidden" name="action" value="add"> 
		<input type="hidden" name="item_id">
		 商品名：<input type="text" name="name" placeholder="商品名" required><br>
		 価格：<input type="number" name="price" placeholder="価格" required><br>
		 <label>ブランドID：
		  <select name="brand_id" required>
		    <option value="1">People Tree</option>
		    <option value="2">Enter the E</option>
		    <option value="3">KAPOK KNOT</option>
		    <option value="4">oblekt</option>
		    <option value="5">CASA FLINE</option>
		    <option value="6">rrrrrrrrr</option>
		    <option value="7">SOLIT!</option>
		  </select>
		</label>
		 商品説明：<textarea name="description" rows="3" cols="40" required></textarea><br> 
		 在庫数：<input type="number" name="stock" placeholder="在庫数" required><br>
		 メイン画像：<input type="file" name="image_url" placeholder="画像URL" required><br>
		 サブ画像1：<input type="file" name="sub_image1" placeholder="画像URL"><br>
		 サブ画像2：<input type="file" name="sub_image2" placeholder="画像URL"><br>
		 サブ画像3：<input type="file" name="sub_image3" placeholder="画像URL"><br>
		 サブ画像4：<input type="file" name="sub_image4" placeholder="画像URL"><br>
		<button type="submit">登録</button>
	</form>

	<script>
		function openModal(id) {
			document.getElementById(id).style.display = 'block';
		}

		function closeModal(id) {
			document.getElementById(id).style.display = 'none';
		}

		//モーダル外クリック時閉じる
		window.onclick = function(event) {
			const modals = document.querySelectorAll('.modal');
			modals.forEach(function(modal) {
				if (event.target == modal) {
					modal.style.display = "none";
				}
			});
		}
	</script>

</body>
</html>