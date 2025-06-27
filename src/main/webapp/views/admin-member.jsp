<%@page import="jp.co.aforce.beans.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 List<UserBean>userList=(List<UserBean>)request.getAttribute("userList");
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報管理</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin-page.css">
</head>
<body>
<a href="<%=request.getContextPath()%>/views/admin-home.jsp">ホームへ戻る</a>

<% if(userList != null && !userList.isEmpty()){ %>
	<table border="1">
	<tr>
		<th>会員番号</th>
		<th>姓</th>
		<th>名</th>
		<th>住所</th>
		<th>メールアドレス</th>
		<th>パスワード</th>
		<th>管理権限</th>
	</tr>
<% for(UserBean userBean:userList){ %>
	<tr>
		<td><%=userBean.getMember_id() %></td>
		<td><%=userBean.getLast_name() %></td>
		<td><%=userBean.getFirst_name() %></td>
		<td><%=userBean.getAddress() %></td>
		<td><%=userBean.getMail_address() %></td>
		<td><%=userBean.getPassword() %></td>
		<td><%=userBean.getIs_admin() %></td>
		
		<td>
		  <form action="<%=request.getContextPath()%>/adminuserprepareservlet" method="get">
		    <input type="hidden" name="member_id" value="<%=userBean.getMember_id()%>">
		    <input type="submit" value="編集">
		  </form>
		</td>
		<td>
		  <form action="<%=request.getContextPath()%>/adminuserdeleteservlet" method="post"
		   onsubmit="return confirm('本当に削除してよろしいですか？');">
		    <input type="hidden" name="member_id" value="<%=userBean.getMember_id()%>">
		    <input type="submit" value="削除">
		  </form>
		</td>
	</tr>
	<% } %>
	
	</table>
	
	
	<% } else { %>
	<p>会員情報が見つかりませんでした。</p>
<% } %>

</body>
</html>