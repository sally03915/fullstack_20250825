<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/header.jsp" %> 
   <div class="container card  my-5 p-4">
      <h3 class="card-header"> MBTI 글상세보기</h3>
	  <div> 
		  <div class="mb-3 mt-3">
		    <label for="name" class="form-label">NAME:</label>
		    <input type="text" class="form-control" id="name"  value="${dto.name}"
		    	readonly placeholder="MBTI 유형을 입력해주세요" name="name">
		  </div> 
		  <div class="mb-3">
		    <label for="description" class="form-label">CONTENT:</label>
		    <textarea class="form-control" id="description"   readonly ]
		     placeholder="MBTI 설명을 입력해주세요" name="description">${dto.description}</textarea>
		  </div>
		  
		  <c:if   test="${not empty email}">
			  <div class="mb-3">
			  	<a href="${pageContext.request.contextPath}/updateForm.mbti?id=${dto.mbtiTypeId}" class="btn btn-success form-control">글수정</a>
			  </div>
			  <div class="mb-3">
			  	<a href="${pageContext.request.contextPath}/delete.mbti?id=${dto.mbtiTypeId}" class="btn btn-secondary form-control">글삭제</a>
			  </div>
		  </c:if>
		  
		  
		  <div class="mb-3">
		  	<a href="${pageContext.request.contextPath}/mbtiAll.mbti" class="btn btn-primary form-control">목록보기</a>
		  </div>
	 </div>
   </div> 
<%@include file="../inc/footer.jsp" %>

<!-- [ mbtiBoard - list.jsp ]  -->