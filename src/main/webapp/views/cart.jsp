<%@page import="jp.co.aforce.dao.ItemDao"%>
<%@page import="jp.co.aforce.beans.ItemBean"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user-pages.css">

</head>
<body>
<table border="1">
			<tr><th>画像</th><th>商品名</th><th>価格</th><th>数量</th><th>小計</th></tr>
<%
	Map<Integer, Integer>cartMap=(Map<Integer, Integer>) session.getAttribute("cart");
	if(cartMap == null || cartMap.isEmpty()){
%>
		<p>カートは空です</p>
<% }else{ %>
<%
    ItemDao itemDao=new ItemDao();
	int total=0;
	for(Map.Entry<Integer, Integer> entry:cartMap.entrySet()){
		int itemId=entry.getKey();
		int quantity=entry.getValue();
		
		ItemBean item=itemDao.getItemById(itemId);
		if (item != null) {
		int subtotal=item.getPrice() * quantity;
		total += subtotal;
%>
		<tr>
			<td><img src="<%= request.getContextPath() + "/" + item.getImage_url() %>" width="100"></td>
			<td><%=item.getName() %></td>
			<td><%=item.getPrice() %></td>
			
			<td>
			<form action="<%=request.getContextPath()%>/updatecartservlet" method="post">
			<input type="number" name="quantity" value="<%=quantity %>" min="1">
			<input type="hidden" name="itemId" value="<%= itemId %>">
    		<input type="hidden" name="action" value="update">
    		<input type="submit" value="数量変更">
    		</form>
			</td>
			
			<td><%=subtotal %>円</td>
			
			<td>
			<form action="<%=request.getContextPath()%>/updatecartservlet" method="post" style="display:inline;">
			<input type="hidden" name="action" value="delete">
			<input type="hidden" name="itemId" value="<%=itemId %>">
			<input type="submit" value="削除">
			</form>
			</td>
		</tr>
<% 
		} 
	}
%>
		<tr><td colspan="3">合計金額</td><td><%=total %>円<td></tr>
		</table>
		
		<form action="<%=request.getContextPath() %>/purchasecheckservlet" method="post">
		<input type="submit" value="ご購入手続きへ">
		</form>
<% } %>

<a href="<%=request.getContextPath() %>/itemlistservlet">買い物を続ける</a>
</body>
</html>