<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>자유 게시판</title>
		<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
		<script src="resources/bootstrap/js/bootstrap.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css" />
		<style>
			#freeList{
				position: absolute;
				left: 270px;
				top: 290px;
			}
			#title{
				width: 270px;
				text-align: right;
			}
			.search{
				text-align: right;
			}
			th{
				text-align: center;
			}
		</style>
	</head>
	<body>
		<jsp:include page="../../resources/include/logo.jsp" />
		<jsp:include page="../../resources/include/nav.jsp" />
		<div id="title">
			<h3>자유 게시판</h3>
		</div>
		<div id="searchList">
			<table width="100%">
				<tr>
					<td><button>글작성</button></td>
					<td class="search">
						<button>검색</button>
						<input type="text" size="20" />
					</td>
				</tr>
			</table>
		</div>
		<div id="freeList">
			<table class="table table-hover totalTable">
				<thead>
					<tr>
						<th>순번</th>
						<th>글쓴이</th>
						<th>제목</th>
						<th>조회 수</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>0</td>
						<td>OOO</td>
						<td>OOOOO</td>
						<td>0</td>
					</tr>
				</tbody>
			</table>
		</div>
	</body>
	<script></script>
</html>