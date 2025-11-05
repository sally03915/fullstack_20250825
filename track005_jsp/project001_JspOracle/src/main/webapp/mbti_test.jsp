<%@page import="com.thejoa703.dto.MbtiDto"%>
<%@page import="com.thejoa703.dao.MbtiDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card  my-5">
      <h3  class="card-header">1. INSERT  </h3>
<%--       <%
      //insert into mbtitype ( MBTI_TYPE_ID ,name,  description)  
      // values ( mbtitype_seq.nextval , ?,?);
      MbtiDao dao = new MbtiDao();
      MbtiDto dto = new MbtiDto();
      dto.setName("1");
      dto.setDescription("1");
      out.println(dao.insert(dto));
      %>  --%>
      <h3  class="card-header">2. SELECT  </h3>
<%--       <%
      MbtiDao dao = new MbtiDao();
      out.println(dao.selectAll());
      %> --%> 
      <h3  class="card-header">3. UPDATE  </h3>
<%--       <%
      MbtiDao dao = new MbtiDao(); 
      out.println(dao.select(3));
      %>  --%>
      <h3  class="card-header">4. DELETE  </h3>
      <%
      MbtiDao dao = new MbtiDao(); 
      out.println(dao.delete(3));
      
      %> 
   </div>
</body>
</html>