<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../inc/header.jsp" %>

   <div class="container card  my-5 p-4">
      <h3 class="card-header"> 관리자 MBTI USER BOARD</h3>  
      <table class="table table-striped table-bordered table-hover">
      	<caption>mbti </caption>
      	<thead>
      		<tr>
      			<th scope="col">NO</th>
      			<th scope="col">USERNO</th>
      			<th scope="col">EMAIL</th>
      			<th scope="col">MBTI TYPE</th>
      			<th scope="col">DATE</th> 
      		</tr>	
      	</thead>
      	<tbody>   
      	  <c:forEach  var="dto"  items="${list}"  varStatus="status">  	
	  		<tr>
	  		    <%-- <td>${dto}</td> --%>
	  			<td>${list.size()-status.index}</td> <!-- 3-0=3  3-1=2  3=2=1  -->
	  			<td>${dto.appUserId}</td>
	  			<td> <a href="${pageContext.request.contextPath}/mypage.users?appUserId=${dto.appUserId}">
	  				${dto.email}
	  			</a> </td> 
	  			<td>${dto.mbtiTypeId}</td>
	  			<td>${dto.createdAt}</td> 
	  		 <tr>
	  	  </c:forEach> 
      	</tbody>
      </table>  
   </div>
   
<%@include file="../inc/footer.jsp" %>

<!-- [ mbtiBoard - list.jsp ]  -->