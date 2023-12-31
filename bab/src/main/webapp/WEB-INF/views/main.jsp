<%@page import="com.practice.domain.ReviewDTO"%>
<%@page import="com.practice.service.StarService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>


<!-- 메인페이지 헤드2 -게시판 안내- -->
<div class="gnb-wrap">
	<div class="inner">
		<nav id="gnb" class="gnb">
			<ul class="gnb_ul">
				
				<li class="qna"><a href="/board/list?page=1&amount=10&type=&keyword="> <span>게시판</span>
				</a></li>
			</ul>
		</nav>
		<!--// gnb -->
	</div>
	<!--// inner -->
</div>


<!-- 대문 이미지 슬라이드 -->
<div class="slideshow-container">
	<div class="slides">
		<div class="mySlides fade1 active">
			<img
				src="/main/images/korean.jpg"
				style="width: 100%; height: 450px;">
		</div>
		<div class="mySlides fade1 active">
			<img
				src="/main/images/sushi.jpg"
				style="width: 100%; height: 450px;">
		</div>
		<div class="mySlides fade1 active">
			<img
				src="/main/images/chinese.jpg"
				style="width: 100%; height: 450px;">
		</div>
		<div class="slide_btn" style="text-align: center">
			<div class="dot active"></div>
			<div class="dot"></div>
			<div class="dot"></div>
		</div>
	</div>
</div>






<!-- 메뉴 선택 박스 -->
<section class="box highlight">
	<ul class="special">

		<li class="category_icon"><img src="/main/img/korean.png" alt=""
			data-genre="한식" /> <span class="genre">한식</span></li>
		<li class="category_icon"><img src="/main/img/japanese.png"
			alt="" data-genre="일식" /> <span class="genre">일식</span></li>
		<li class="category_icon"><img src="/main/img/chinese.png" alt=""
			data-genre="중식" /> <span class="genre">중식</span></li>
		<li class="category_icon"><img src="/main/img/western.png" alt=""
			data-genre="양식" /> <span class="genre">양식</span></li>
		<li class="category_icon"><img src="/main/img/fastfood.png"
			alt="" data-genre="패스트푸드" /> <span class="genre">패스트푸드</span></li>
		<li class="category_icon"><img src="/main/img/desert.png" alt=""
			data-genre="카페" /> <span class="genre">카페</span></li>
			
	</ul>
</section>



<!-- 중간 : 카테고리별 음식점 랭킹순 정렬
	메인 페이지 카테고리 클릭 전까지는 컨트롤러로 api 불러오기
	카테고리 클릭 시 fetch로 접근
 -->
 
 
<div class="category_section_wrap">
	<!-- 라인 반복 -->
	<section id="korean" class="bg-white category_section_line_wrap">
		<div class="loop">
			<span class="food_category_name">#한식</span>
		</div>
		<div
			class="container mx-auto flex items-center flex-wrap loop_section">
 
			<!-- 라인 내 음식점 반복구간 -->
			<c:forEach var="food" items="${list}">
				<div
					class="w-full md:w-1/3 xl:w-1/4 p-6 flex flex-col hover:grow hover:shadow-lg restaurant_link">
					<a href="" class="image_link"> <img id="image_link"
						src="${food.imageLink}" style="width: 205px; height: 235px;"
						data-title="${food.title}">
					</a> 
					<div id="shortcuts" class="pt-3 flex items-center">
						<div class="line_diveider">
							<p>
								<a href="..." id="store_name"> <span class="restaurant_name">${food.title}
								</span> <strong class="point search_point "></strong>
								</a>
							</p>

						</div>

					</div>
				</div>
			</c:forEach>
		
			
			
		</div>
	</section>	

</div>

<script src = "/main/js/main.js"></script>
<script src="/main/js/wish.js"></script>
<script src = "/restaurants/js/result.js"></script>

<%@ include file="include/footer.jsp"%>