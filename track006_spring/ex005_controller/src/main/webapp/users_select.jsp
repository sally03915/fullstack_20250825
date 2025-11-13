<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script  src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
<div>
	<div class="container panel panel-warning">
		<h3 class="panel-heading">USER - CRUD( select )</h3>
		<table class="table table-striped">
			<thead>
			<tr> <th scope="col">NO</th> <th scope="col">NAME</th> <th scope="col">AGE</th> </tr>
			</thead>
			<tbody>
		 	<tr><td>${dto.no}</td><td>${dto.name}</td><td>${dto.age}</td></tr>
			</tbody>
		</table>
		<p><a href="${pageContext.request.contextPath}/list.do" class="btn btn-danger" >돌아가기</a></p>
 
	</div>
</div>	
</body>
</html>
