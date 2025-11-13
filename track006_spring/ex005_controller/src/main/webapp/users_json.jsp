<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html  lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container panel panel-success">
		<h3 class="panel-heading">USER MBTI TYPE </h3>
		<table  class="table table-striped  userTable">
			<caption>USERS</caption>
			<thead><tr><th scope="col">NO</th><th scope="col">EMAIL</th><th scope="col">MBTITYPE</th>
					<th scope="col">조회</th><th scope="col">수정</th><th scope="col">삭제</th></tr></thead>
			<tbody> </tbody>
		</table>
		<h3 class="panel-heading">USERS 데이터 삽입/수정  (INSERT/UPDATE)</h3>
		<form  action="#"  method="get"  id="userForm">
			<fieldset>
			<legend>USERFORM</legend>
			<div class="mb-3 mt-3">
				<label  for="email" class="form-label">Email:</label> 
				<input  type="email" class="form-control" id="email"
						placeholder="이메일을 입력해주세요" required  name="email">
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password:</label> 
				<input type="password" class="form-control" id="password"
						placeholder="비밀번호를 입력해주세요" name="password">
			</div>		
			<div class="mb-3">
				<label class="form-check-label"  for="mbtiTypeId">MBTI TYPE : </label>  
				<select   name="mbtiTypeId"  id="mbtiTypeId"  class="form-control">
					<option value="1">ISTJ</option>
					<option value="2">ISFJ</option>
					<option value="3">INFJ</option>
				</select>
				
			</div>
			<div class="userhidden_no"></div>
			<div class="mb-3">
				<input type="button"  value="USER 데이터 삽입"   
					   class="btn btn-danger"   title="USER 데이터삽입"  id="insertUser" />
				<input type="button"  value="USER 데이터 수정"   
					   class="btn btn-danger"   title="USER 데이터수정"  id="updateUser" />
				<input type="reset"  class="btn btn-primary" value="초기화" id="userInit" />
			</div>
			</fieldset>
		</form>
	</div>
	<script>
	$(function(){
		userList();
		userSelect();
		userInsert();
		userUpdate();
		userDelete(); 
	});
	function  userList(){
		$.ajax({
			url : "list" , 
			type: "GET" , 
			dataType:"json" ,
			contentType: "application/json;charset=UTF-8", 
			error:function(xhr, status, msg){ alert( status + "/" + msg); } , 
			success : userListResult , 
		});
	}
	function userListResult(json){
		console.log( json );
		console.log( json.result );   // result : true
		console.log( json.data   );   // [{},{}]
		
		$(".userTable  tbody").empty();   // 테이블   tbody
		var   total = json.data.length;
		$.each(json.data , function(idx, user){
			$("<tr>")
			.append(  $("<td>").html( total - idx ))
			.append(  $("<td>").html( user.email   ))
			.append(  $("<td>").html( user.mbtiTypeId  ))
			.append(  $("<td>").html( "<input type='button' class='selectUser' value='조회'/>"))
			.append(  $("<td>").html( "<input type='button' class='selectUser' value='수정'/>"))
			.append(  $("<td>").html( "<input type='button' class='deleteUser' value='삭제'/>"))
			.append(  $("<input type='hidden' class='hidden_id'   />").val(user.appUserId)  )
			.append(  $("<input type='hidden' class='hidden_email' />").val(user.email))
			.appendTo(".userTable  tbody");    //   테이블   tbody
		});
	}
	
	function  userSelect(){
		$("body").on("click" , ".selectUser" , function(){
			//alert("hi");
			var  appUserId = $(this).closest("tr").find('.hidden_id').val();
			//선택자 이용해서 가져오기  #####   가장 가까이에 있는tr을  안에 있는 no
			$.ajax({
				url : "select/" + appUserId , 
				type: "GET" , 
				//data: JSON.stringify({ no: no})
				dataType:"json" ,
				contentType: "application/json;charset=UTF-8", 
				error:function(xhr, status, msg){ alert( status + "/" + msg); } , 
				success : userSelectResult , 
			});
		});
	}
	
	function userSelectResult(json){
		$("#name").val(json.data.name);   // input  val
		$("#age" ).val(json.data.age);
		$(".userhidden_no")
		 .html( $("<input type=\"hidden\"  class=\"hidden_no\"/>").val(json.data.no) );  // div - 기본태그   html, append
 	}
	
	function  userInsert(){
		$("#insertUser").on("click"  , function(){
			var email = $("#email").val();
			var mbtiTypeId  = $("#mbtiTypeId").val();
			if( email ==""  ){  alert("빈칸입니다\n확인해주세요");  $("#email").focus();  return false; }
			if( mbtiTypeId  ==""  ){  alert("빈칸입니다\n확인해주세요");   $("#mbtiTypeId").focus();  return false; }
			
			$.ajax({
				url : "insertUser" , 
				type: "POST" , 
				dataType:"json", 
				contentType:"application/json",  
				data : JSON.stringify({email:email, mbtiTypeId:mbtiTypeId}),
				mimeType:"application/json",
				error:function(xhr, status, msg){ alert( status + "/" + msg); } , 
				success : function( json ){ if( json.result == true ){ userList(); }  } , 
			});
			//$("#name").val("");
			//$("#age").val(""); 
			$("#userForm").each(function(){  this.reset();  });
		});
	}   // insert 하고나서 userList()
	function  userUpdate(){
		// 해당번호의 이름과 나이를 수정해주세요!
		$("#updateUser").on("click"  , function(){
			var name = $("#name").val();
			var age  = $("#age").val();
			var no   = $(".userhidden_no  .hidden_no").val();
			
			if( name ==""  ){  alert("빈칸입니다\n확인해주세요");  $("#name").focus();  return false; }
			if( age  ==""  ){  alert("빈칸입니다\n확인해주세요");   $("#age").focus();  return false; }
			
			$.ajax({
				url : "updateUser" , 
				type: "PUT" , 
				dataType:"json", 
				contentType:"application/json",  
				data : JSON.stringify({name:name, age:age , no:no}),
				mimeType:"application/json",
				error:function(xhr, status, msg){ alert( status + "/" + msg); } , 
				success : function( json ){ if( json.result == true ){ userList(); }  } , 
			});
			//$("#name").val("");
			//$("#age").val(""); 
			$("#userForm").each(function(){  this.reset();  });
		});
	}   // update 하고나서 userList()
	function  userDelete(){
		$("body").on("click" , ".deleteUser"  , function(){
			var no   = $(this).closest("tr").find(".hidden_no").val();
			var name = $(this).closest("tr").find(".hidden_name").val();
			// alert , confirm, prompt
			//alert('test');  알림창   ,  confirm('할래?'); yes, no  ,   prompt('이름?');  입력받는창
			if(  confirm(name + " 유저를 삭제하시겠습니까?")){
				$.ajax({
					url : "deleteUser/" + no , 
					type: "DELETE" , 
					dataType:"json", 
					contentType:"application/json", 
					error:function(xhr, status, msg){ alert( status + "/" + msg); } , 
					success : function( json ){ if( json.result == true ){ userList(); }  } , 
				});
			}// end if
		});
	}   // delete 하고나서 userList()
 
	</script>

</body>
</html>

