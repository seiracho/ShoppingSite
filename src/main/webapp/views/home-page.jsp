<%@page import="jp.co.aforce.beans.BrandBean"%>
<%@page import="jp.co.aforce.beans.ItemBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/views/header.jsp" %>
    
 <% List<ItemBean> itemList=(List<ItemBean>)request.getAttribute("itemList"); 
 List<BrandBean> brandList=(List<BrandBean>)request.getAttribute("brandList");
 %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/home-page.css">
<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@500&display=swap" rel="stylesheet">

</head>
<body>

<section class="main-visual">
<div class="overlay">
<img src="<%=request.getContextPath() %>/purchase_method_img/1-94e2db0e.jpg" alt="トップ画像" class="main-image">
		<h1>What you want and what you choose</h1>
		<p>あなたの必要を選んでみて</p>
</div>
</section>
	
	<main>
		
		<section>
			<h2>ITEM</h2>
			<div class="slider-wrapper">
			<button class="slide-btn left">←</button>
			<div class="slider" >
			<% if(itemList !=null && !itemList.isEmpty()) { %>
			<% for(ItemBean item:itemList){ %>
			<div class="item-card">
			<a href="<%=request.getContextPath() %>/itemdetailservlet?item_id=<%=item.getItem_id()%>">
			<img src="<%=request.getContextPath() %>/<%=item.getImage_url() %>" alt="<%=item.getName() %>" class="item-img">
			<p><%=item.getName() %></p>
			<p>￥<%=item.getPrice() %></p>
			</a>
			</div>
			<%
			} 
			}
			%>
			</div>
			<button class="slide-btn right">→</button>
		</div>
		</section>
		
		<section>
			<h2>BRANDS</h2>
			<div class="slider-wrapper">
			<button class="slide-btn left">←</button>
			<div class="slider">
			<% if(brandList !=null && !brandList.isEmpty()) { 
					for(BrandBean brand : brandList) { %>
						<div class="item-card">
						<a href="<%=request.getContextPath() %>/brandlistservlet?brand_id=<%=brand.getBrand_id()%>">
						<img src="<%=request.getContextPath() %>/<%=brand.getBrand_logo_url()%>" alt="<%=brand.getBrand_name() %>" class="brand-img">
						<p><%=brand.getBrand_name()%></p>
						</a>
						</div>
			<% }
					} %>
			</div>
			<button class="slide-btn right">→</button>
		</div>
		</section>
		
		<section id="contact" class="wrapper">
			<h2>CONTACT</h2>
			<form action="" method="post">
			<dl>
			<dt><label for="name">名前</label></dt>
			<dd><input type="text" id="your-name" required></dd>
			<dt><label for=title>タイトル</label></dt>
			<dd><input type="text" id="your-title" required></dd>
			<dt><label for="mail-address">メールアドレス</label></dt>
			<dd><input type="text" id="your-mail-address" required></dd>
			<dt><label for="contact">お問い合わせ内容</label></dt>
			<dd><input type="text" id="your-contact" required></dd>
			</dl>
			<div class="button"><input type="submit" value="送信"></div>
			</form>
		
		
		</section>
		
	</main>
	<script>
  document.querySelectorAll('.slider-wrapper').forEach(wrapper => {
    const slider = wrapper.querySelector('.slider');
    const btnLeft = wrapper.querySelector('.slide-btn.left');
    const btnRight = wrapper.querySelector('.slide-btn.right');

    btnLeft.addEventListener('click', () => {
      slider.scrollBy({ left: -300, behavior: 'smooth' });
    });

    btnRight.addEventListener('click', () => {
      slider.scrollBy({ left: 300, behavior: 'smooth' });
    });
  });
</script>


</body>
</html>