<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>마이페이지</title>
	
	<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css" />
	<style>
		table{
			width: 100%;
		}
		#myimporm th{
	        text-align: right;
	        padding-bottom: 10px;
	        padding-right: 10px;
	        width: 20%;
		}
		#myimporm td{
		  padding-bottom: 10px;
		   width: 30%;
		   height: 36px;
		   text-align: center;
		}
		#mypoin td{
			width: 6%;
			border: 1px solid;
			text-align: center;
			font-size: 14;
		}
	</style>
</head>
<body>
	<jsp:include page="../../resources/include/logo.jsp" />
	<jsp:include page="../../resources/include/loginBox.jsp" />
	<jsp:include page="../../resources/include/nav.jsp" />
	<div class=" layer">
	<div class="page">
		<div class="col2 content">
		<!-- 배너 -->
		</div>
		<div class="col5 content"> 
            <div class="well bs-component">
			  <fieldset>
			  	<legend>마이페이지</legend>
			  		<table id="myimporm">
			  			<tr>
			  				<th>아이디</th>
			  				<td>${user.u_id}</td>
			  				<th>성명</th>
			  				<td>${user.u_name}</td>
			  			</tr>
			  			<tr>
			  				<th>성별</th>
			  				<td>${user.u_gender}</td>
			  				<th>생년월일</th>
			  				<td>${user.u_age}</td>
			  			</tr>
			  			<tr>
			  				<th>핸드폰</th>
			  				<td>${user.u_phnum}</td>
			  				<th>이메일</th>
			  				<td>${user.u_mail}</td>
			  			</tr>
			  			<tr>
			  				<td colspan="4">
				        		<button class="btn btn-primary" onclick="location='./userModify?id=${user.u_id}'">수정</button>
			  				</td>
			  			</tr>
			  		</table>
			  		
			  </fieldset>
			</div>
		</div>
		<div class="col3 content">      
		<!-- 배너 -->
		</div>
		</div>
	</div>
	<jsp:include page="../../resources/include/footer.jsp" />
	</body>
	<script>
	$(document).ready(function(){
		var frm = document.getElementById('mainForm');
		for (var i=0; i<3; i++) {
			frm['myTeam'].options[i] = new Option(i+1, i+1);
		}
		frm['dateYear'].value = 1;
	});
	</script>
</html>