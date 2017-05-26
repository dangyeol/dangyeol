<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<h2>상품 리스트</h2>
	<p>The .table-striped class adds zebra-stripes to a table:</p>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Product_Name</th>
				<th>상세보기</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.pro_Name }</td>
					<td><a href="detailproduct?pro_Name=${list.pro_Name }">상세보기</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>