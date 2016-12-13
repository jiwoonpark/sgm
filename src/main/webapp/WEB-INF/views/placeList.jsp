<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>장소목록 게시판</title>
		<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
		<script src="resources/bootstrap/js/bootstrap.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css" />
		<style>
			#map{
				border:1px solid;
				width: 100%;
				margin-bottom: 10px;
			}
			#search{
				text-align: center;
			}
			#placeList{
				position: absolute;
				left: 270px;
			}
			
			.table{
				width: 700px;
				text-align: center;
				border-bottom: 1px solid silver;
			}
			
			th{
				text-align: center;
			}
		</style>
	</head>
	<body>
		<jsp:include page="../../resources/include/logo.jsp" />
		<jsp:include page="../../resources/include/nav.jsp" />
		<div id="map">
			지도	
		</div>
		<div id="search">
			<select>
				<option value="1">OO구</option>
			</select>
			<input type="text" size="40" />
			<button>검색</button>
		</div>
		<div id="placeList">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>사진</th>
						<th class="center">제목</th>
						<th class="center">날짜</th>
						<th>비교</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>사진</td>
						<td>제목</td>
						<td>날짜</td>
						<td>비교</td>
					</tr>
				</tbody>
			</table>
		</div>
	</body>
	<script></script>
</html>