<%@page import="jp.co.aforce.beans.ItemBean"%>
<%@page import="jp.co.aforce.dao.ItemDao"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    jp.co.aforce.beans.UserBean user = (jp.co.aforce.beans.UserBean)session.getAttribute("user");
    
    Map<Integer, Integer>cartMap=(Map<Integer, Integer>)session.getAttribute("cart");
    ItemDao itemDao=new ItemDao();
    int total=0;
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入完了</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user-pages.css">

</head>
<body>
<div class="complete-box">
	<h1><%=user.getLast_name()+user.getFirst_name()%>様、ご購入ありがとうございました♡</h1>
	<%
    Integer orderId=(Integer)session.getAttribute("lastOrderId");
    if(orderId != null){
    %>
    <p>ご注文番号：<%=orderId %></p>
    <%
    session.removeAttribute("lastOrderId");
    } 
    %>
    <h2>ご注文内容</h2>
    <%
    if(cartMap !=null && !cartMap.isEmpty()){
    %>
    <table>
    	<tr><th>商品名</th><th>数量</th><th>小計</th></tr>
    <% for(Map.Entry<Integer, Integer> entry:cartMap.entrySet()){
    	int itemId=entry.getKey();
    	int quantity=entry.getValue();
    	ItemBean itemBean=itemDao.getItemById(itemId);
    	if(itemBean != null){
    		int subtotal=itemBean.getPrice() * quantity;
    		total += subtotal;
    %>
    	<tr>
    		<td><%=itemBean.getName() %></td>
	    	<td><%= quantity %></td>
	    	<td><%= subtotal %></td>
    	</tr>
    <%
    	} 
    } 
    %>
    	<tr><td colspan="2">合計金額</td><td><%= total %>円</td></tr>
    </table>
    <%
    session.removeAttribute("cart");
    } else {
    %>
    <p>購入商品が見つかりません</p>
    <% } %>
	<p>注文確定日より5営業日以内にヤマト運輸にて発送いたします。</p>
	<p>MyPageからも注文履歴の確認ができます。</p>
	<a href="<%=request.getContextPath()%>/views/user-menu.jsp">MyPage</a>
	<a href="<%=request.getContextPath()%>/homepageshowservlet">ホームページに戻る</a>
</div>

</body>
</html>