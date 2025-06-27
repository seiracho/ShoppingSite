<%@page import="jp.co.aforce.beans.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	UserBean user=(UserBean) session.getAttribute("user");

	if(user == null){
		response.sendRedirect(request.getContextPath() + "/views/login-in.jsp");
		return;
	}

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>