<%@page import="jp.co.aforce.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    UserBean userBean=(UserBean)request.getAttribute("userList");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報編集</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin-page.css">
</head>
<body>
	<h2>会員情報編集</h2>
	<form action="<%=request.getContextPath() %>/adminusereditservlet" method="post"
		onsubmit="return confirm('本当に更新してよろしいですか？');">
		<input type="hidden" name="member_id" value="<%=userBean.getMember_id() %>">
		
		<input type="text" name="last_name" value="<%=userBean.getLast_name()%>" required>
		<input type="text" name="first_name" value="<%=userBean.getFirst_name()%>" required>
		<input type="text" name="address" value="<%=userBean.getAddress()%>" required>
		<input type="email" name="mail_address" value="<%=userBean.getMail_address()%>" required pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}">
		<input type="text" name="password" value="<%=userBean.getPassword()%>" pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$"
       title="8文字以上で英字と数字を含めてください" required>
		
		<input type="submit" value="更新">
	</form>
		<a href="<%=request.getContextPath() %>/adminuserservlet">戻る</a>
</body>
</html>