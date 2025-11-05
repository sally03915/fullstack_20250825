<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>

  <div class="container card  my-5 p-4">
     <h3 class="card-header"> MBTI TYPE글수정</h3>
  <form action="<%=request.getContextPath()%>/update.mbti?id=${dto.mbtiTypeId}"  method="post">  
	  <div class="mb-3 mt-3">
	    <label for="name" class="form-label">NAME:</label>
	    <input type="text" class="form-control" id="name" placeholder="MBTI 유형을 입력해주세요" 
	    	name="name"  value="${dto.name}">
	  </div> 
	  <div class="mb-3">
	    <label for="description" class="form-label">CONTENT:</label>
	    <textarea class="form-control" id="description" placeholder="MBTI 설명을 입력해주세요"
	    	 name="description">${dto.description}</textarea>
	  </div>
	  <div class="mb-3  text-end">
	  	<button type="submit" class="btn btn-primary">글수정</button>
	  	<a href="javascript:history.go(-1)"  class="btn btn-danger">BACK</a>
	  </div>
 </form>
  </div>
   
<%@include file="../inc/footer.jsp" %>

<!-- [ mbtiBoard - list.jsp ]  -->