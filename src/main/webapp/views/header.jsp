<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="jp.co.aforce.beans.UserBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

<header class="main-header">
		<nav class="navbar">
		<div class="site">
		<a href="<%=request.getContextPath()%>/homepageshowservlet">SELECT WYN</a>
		</div>
			<ul class="nav-links">
				<li><a href="<%=request.getContextPath()%>/homepageshowservlet">HOME</a></li>
				<li><a href="<%=request.getContextPath()%>/views/about.jsp">ABOUT</a></li>
				<li><a href="<%=request.getContextPath()%>/itemlistservlet">ITEM</a></li>
				<li><a href="<%=request.getContextPath()%>/brandlistservlet">BRANDS</a></li>
				<li><a href="<%=request.getContextPath()%>/homepageshowservlet#contact">CONTACT</a></li>
				
<!--			<% if (session.getAttribute("user") != null) { %>-->
				<li><a href="<%=request.getContextPath()%>/mypageservlet">My Page&#128587;</a></li>
					   
<!--			<% } else { %>-->
				<li><a href="<%=request.getContextPath()%>/views/login-in.jsp">Login</a></li>
<!--			<% } %>-->
				<li><a href="<%=request.getContextPath()%>/cartservlet">Cart🛒</a></li>
			</ul>
		</nav>	
	</header>
