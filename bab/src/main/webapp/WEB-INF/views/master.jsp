<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>

<!-- 메인페이지 헤드2 -게시판 안내- -->
<div class="gnb-wrap">
	<div class="inner">
		<nav id="gnb" class="gnb">
			<ul class="gnb_ul">
				
				<li class="qna"><a
					href="/board/list?page=1&amount=10&type=&keyword="> <span>게시판</span>
				</a></li>
			</ul>
		</nav>
		<!--// gnb -->
	</div>
	<!--// inner -->
</div>



<table class="table table-bordered table-hover" id="requestTable">
	<thead>
		<tr>
			<th scope="col" width="10%" style="text-align: center;">등록번호</th>
			<th scope="col" width="20%" style="text-align: center;">맛집 이름</th>
			<th scope="col" width="40%" style="text-align: center;">맛집 주소</th>
			<th scope="col" width="15%" style="text-align: center;">등록 유저</th>
			<th scope="col" width="15%" style="text-align: center;">요청일자</th>
		</tr>
	</thead>
	
	
	<tbody>
		<c:forEach var="list" items="${list}">
			<tr>
				<th scope="row" style="text-align: center;">${list.reqId}</th>
				<td class="post-title" style="text-align: center;"><a href="${list.reqId}" class="move" >${list.reqName}</a>
				<td class="post-content" style="text-align: center;">${list.reqAddress}</td>
				<td class="author" style="text-align: center;">${list.reqUser}</td>
				<td class="date" style="text-align: center;"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list.reqDate}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- 페이지 나누기 시작 -->
<nav aria-label="...">
	<ul class="pagination justify-content-center pb-3">
		<c:if test="${pageDTO.prev}">
			<li class="page-item"><a class="page-link"
				href="${pageDTO.startPage-1}">Previous</a></li>
		</c:if>

		<c:forEach begin="${pageDTO.startPage}" end="${pageDTO.endPage}"
			var="idx">
			<!-- <li class="page-item active"></li> -->
			<li class="page-item ${pageDTO.cri.page==idx?'active':'' }"><a
				class="page-link" href="${idx}">${idx}</a></li>

		</c:forEach>	

		<c:if test="${pageDTO.next}">
			<li class="page-item"><a class="page-link"
				href="${pageDTO.endPage+1}">Next</a></li>
		</c:if>
	</ul>
</nav>
<!-- 페이지 나누기 종료  -->
<!-- 페이지 나누기 링크 처리를 위한 폼 -->
<form action="/api/master" id="operForm">
	<%-- pageDTO.cri.page 가능  --%>
	<input type="hidden" name="page" value="${cri.page}" /> 
	<input type="hidden" name="amount" value="${cri.amount}" /> 
</form>

<script src="/master/list.js"></script>
<%@ include file="include/footer.jsp"%>