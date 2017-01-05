<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String lat=request.getParameter("lat");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>장소목록 지도에 불러오기</title>
		<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
		<style></style>
	</head>
	<body>
		<!-- 지도를 표시할 div 입니다 -->
		<div id="map" style="width:100%;height:350px;"></div>



	

<<<<<<< HEAD:src/main/webapp/resources/include/mapSearch.jsp
	<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=eea8daf781b745669919ab906f673fea&libraries=services"></script>
=======
	<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=4c80c1326b8411cbdc60e962e2c46260&libraries=services"></script>
>>>>>>> 60a548339569d21aef177725e73a4cf3db1f42b6:src/main/webapp/resources/include/placeMap.jsp
	<script>
	$("#map").empty();
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
<<<<<<< HEAD:src/main/webapp/resources/include/mapSearch.jsp
			center: new daum.maps.LatLng(37.447357, 126.6824384), // 지도의 중심좌표
			
	        level: 7 // 지도의 확대 레벨
=======
			center: new daum.maps.LatLng(37.472357, 126.6824384), // 지도의 중심좌표
			
	        level: 10 // 지도의 확대 레벨
>>>>>>> 60a548339569d21aef177725e73a4cf3db1f42b6:src/main/webapp/resources/include/placeMap.jsp
	    };
	   
		//지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new daum.maps.Map(mapContainer, mapOption); 
<<<<<<< HEAD:src/main/webapp/resources/include/mapSearch.jsp
=======
		

>>>>>>> 60a548339569d21aef177725e73a4cf3db1f42b6:src/main/webapp/resources/include/placeMap.jsp
	
   function areaSearch(lat, lng){
	   $("#map").empty();
	   var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
			center: new daum.maps.LatLng(lat, lng), // 지도의 중심좌표
			
	        level:  3// 지도의 확대 레벨
	    };
	   
		//지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
		var map = new daum.maps.Map(mapContainer, mapOption); 
		
		//마커가 표시될 위치입니다 
			var markerPosition  = new daum.maps.LatLng(lat, lng); 	
		
		//마커를 생성합니다
		var marker = new daum.maps.Marker({
		   position: markerPosition
		});
		
		//마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
		
		//아래 코드는 지도 위의 마커를 제거하는 코드입니다
		//marker.setMap(null);    
   }
   
   function addMarker(lat, lng){
	   console.log(lat+"/"+lng);
		var markerPosition  = new daum.maps.LatLng(lat, lng); 	
		
		//마커를 생성합니다
		var marker = new daum.maps.Marker({
		   position: markerPosition
		});
		
		//마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
   }
</script>
</body>
</html>