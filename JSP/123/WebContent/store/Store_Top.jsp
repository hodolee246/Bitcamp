<%@page import="java.util.ArrayList"%>
<%@page import="Store.StoreDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<StoreDto> list = new ArrayList<StoreDto>();
	list = (List)request.getAttribute("list");
	System.out.println("list size:"+list.size());
	String img_[] = {};
	String str = list.get(0).getProductImage().toString();
	
	
	
	for(StoreDto dto : list){
		System.out.println("foreach:"+dto.getProductImage());
	}
	

%>      
<!DOCTYPE html>
<html lang="en">
<head>
<title>Sublime</title>
<meta charset="utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Sublime project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/123/store/styles/bootstrap4/bootstrap.min.css">
<link href="/123/store/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/123/store/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="/123/store/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="/123/store/plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="/123/store/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="/123/store/styles/responsive.css">
<style type="text/css">
.product{width:calc((100% - 90px) /2 }
</style>
</head>
<body>

<div class="super_container">
<!-- header -->
<div class="header">
		<div class="header_container">
			<div class="header_content">
				<div class="logindiv">
						<a><img src="../image/cart.png" width="20px" height="20px"></a>
						<a>LOGIN</a>
				</div>
				<div class="logo">
						<a><img src="../image/storelogo.png"></a>
				</div>
				
				<div class="navbar">
						<a>ALL</a>
						<a>CLOTHIING</a>
						<a>ACCESORIES</a>
						<a>VINYL</a>
						<a>ETC</a>
					
				</div>
				
			</div>
		</div>
	
</div>
		
		<!-- Search Panel -->
		<div class="search_panel trans_300">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="search_panel_content d-flex flex-row align-items-center justify-content-end">
							<form action="#">
								<input type="text" class="search_input" placeholder="Search" required="required">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</header>


	<!-- Products -->

	<div class="products">
		<div class="container">
			<div style="padding: 0 10% 0 10%;">	
					<div class="product_grid">
					 <%
					for(StoreDto dto : list){
						String str_[] = dto.getProductImage().split(",");
						System.out.println(dto.toString());
						String pImg = "";
						for(int i=0; i<str_.length; i++){
							System.out.println(i+"번째:"+str_[i]);
							if(!str_[i].equals(" ")){
								System.out.println("str_["+i+"]:"+str_[i].toString());
								pImg = str_[i];
								System.out.println(i+"번째 pImg:"+pImg);
								%>
									<!-- Product -->
									<div class="product" style= "width:calc((100% - 90px) /3);">
										<div class="product_image"><img style="height: 300px; width: 400px" src="/123/store/store_images/<%=pImg%>" alt="이미지없음"></div>
										<div class="product_content">
											<div class="product_title"><a href="product.html"><%=dto.getProductName() %></a></div>
											<div class="product_price"><%=dto.getPrice() %></div>
										</div>
									</div>
								<%
								break;
							}
						}
						
						%>
						
						<%
					}
					
					%> 
					</div>
				</div>	
		</div>
	</div>

	<!-- Icon Boxes -->

	<div class="icon_boxes">
		<div class="container">
			<div class="row icon_box_row" style="background-color: rgba(0,0,0,0.1)">
				
				<!-- Icon Box -->
				<div class="col-lg-4 icon_box_col">
					<div class="icon_box">
						<div class="icon_box_image"><img src="/123/store/images/icon_1.svg" alt=""></div>
						<div class="icon_box_title">Free Shipping Worldwide</div>
						<div class="icon_box_text">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie.</p>
						</div>
					</div>
				</div>

				<!-- Icon Box -->
				<div class="col-lg-4 icon_box_col">
					<div class="icon_box">
						<div class="icon_box_image"><img src="/123/store/images/icon_2.svg" alt=""></div>
						<div class="icon_box_title">Free Returns</div>
						<div class="icon_box_text">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie.</p>
						</div>
					</div>
				</div>

				<!-- Icon Box -->
				<div class="col-lg-4 icon_box_col">
					<div class="icon_box">
						<div class="icon_box_image"><img src="/123/store/images/icon_3.svg" alt=""></div>
						<div class="icon_box_title">24h Fast Support</div>
						<div class="icon_box_text">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie.</p>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>
<h1>여기는 NewFIle</h1>
<script src="/123/store/js/jquery-3.2.1.min.js"></script>
<script src="/123/store/styles/bootstrap4/popper.js"></script>
<script src="/123/store/styles/bootstrap4/bootstrap.min.js"></script>
<script src="/123/store/plugins/greensock/TweenMax.min.js"></script>
<script src="/123/store/plugins/greensock/TimelineMax.min.js"></script>
<script src="/123/store/plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="/123/store/plugins/greensock/animation.gsap.min.js"></script>
<script src="/123/store/plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="/123/store/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="/123/store/plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="/123/store/plugins/easing/easing.js"></script>
<script src="/123/store/plugins/parallax-js-master/parallax.min.js"></script>
<script src="/123/store/js/custom.js"></script>

</body>
</html>