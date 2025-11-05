<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/header.jsp" %>

   <div class="container card  my-5 p-4">
      <h3 class="card-header"> MBTI TYPE</h3> 
<%--  					한개			향상된 for 게시판리스트
	  <c:forEach  var="변수명"  items="서버에서넘겨받은값"  varStatus="status">
      </c:forEach>    
--%>
      
      <table class="table table-striped table-bordered table-hover">
      	<caption>mbti </caption>
      	<thead>
      		<tr>
      			<th scope="col">NO</th>
      			<th scope="col">TYPE</th>
      			<th scope="col">DESCRIPTION</th> 
      		</tr>	
      	</thead>
      	<tbody>  
      	<c:forEach  var="dto"  items="${list}"  varStatus="status">
      		<tr>
      			<th scope="col">${list.size() - status.index}</th>
      			<th scope="col"><a href="${pageContext.request.contextPath}/mbti.mbti?id=${dto.mbtiTypeId}">${dto.name}</a></th>
      			<th scope="col">${dto.description}</th> 
      		</tr>
      	</c:forEach>
      </table>
     <% if(email!=null){    %>
		  <p class="text-end">
		  	 <a href="${pageContext.request.contextPath}/regForm.mbti" class="btn btn-primary">MBTI 유형글쓰기</a>
		  </p>	
	  <% }else{  %>
	  	  <p class="text-end alert alert-primary">로그인을 하면 글쓰기가능합니다.</p>
	 <%  }  %>
	  
   </div>
   
<%@include file="../inc/footer.jsp" %>

<!-- [ mbtiBoard - list.jsp ]  -->