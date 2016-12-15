<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<style>
			td{
				
			}	
			.score{
				width: 5%;
			}	
			.info{
				padding-bottom: 7%;
			}
			.evaTable{
				width: 100%;
			}
			.normal{
				border: 1px solid;
				border-collapse: collapse;
			}
			.eva {
				
			}
			.memberSign{
				padding-top: 8%;
				
				text-align: right;
			}
			.member{
				padding-top: 20%;
			}
		</style>
	</head>
	<body>
		<jsp:include page="../../resources/include/logo.jsp" />
		<jsp:include page="../../resources/include/nav.jsp" />
		<div class="layer">
			<div class="page">
				<!-- 첫 번째 구역 -->
				<div class="col2 content">
					<div class="title">
						<h3>팀 게시판</h3>					
					</div>
					<div>
						<jsp:include page="../../resources/include/team.jsp" />
					</div>
				</div>
				
				<!-- 두 번째 구역 -->
				<div class="col5 content">
					<div class="info">
						<table class="table">
							<thead>
								<tr>
									<th colspan="10">기본 정보</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="score">0</td>
									<td class="score">0</td>
									<td class="score">0</td>
									<td class="score">0</td>
									<td class="score">0</td>
									<td class="score">0</td>
									<td>OOO</td>
									<td>OOO</td>
									<td>OOO</td>
									<td>OOO</td>
								</tr>
								<tr>
									<td colspan="3"></td>
									<td colspan="3"></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td colspan="3"></td>
									<td colspan="3"></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="eva col-sm-8">
						<table class="evaTable">
							<tr>
								<th colspan="4">평가 정보</th>
							</tr>
							<tr>
								<td class="normal">OOO</td>
								<td class="normal">OOO</td>
								<td class="normal">OOO</td>
								<td class="normal">OOO</td>
							</tr>
							<tr>
								<td class="normal">OOO</td>
								<td class="normal">OOO</td>
								<td class="normal">OOO</td>
								<td class="normal">OOO</td>
							</tr>
						</table>
					</div>
					<div class="col-sm-4 memberSign">
						<button>멤버 등록</button>
					</div>
					<div class="member">
					----------------------------------------------------------------------------------------------------------------------	
						<table class="table">
							<thead>
								<tr>
									<th>멤버 리스트</th>
								</tr>
								<tr>
									<td>이름</td>
									<td>포지션</td>
									<td>총점</td>
									<td>경기수</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>이름</td>
									<td>포지션</td>
									<td>총점</td>
									<td>경기수</td>
								</tr>
								<tr>
									<td>이름</td>
									<td>포지션</td>
									<td>총점</td>
									<td>경기수</td>
								</tr>
								<tr>
									<td>이름</td>
									<td>포지션</td>
									<td>총점</td>
									<td>경기수</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				
				<!-- 세 번째 구역 -->
				<div class="col3 content">
					
				</div>
			</div>
		</div>
	</body>
	<script></script>
</html>