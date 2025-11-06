package com.thejoa703.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejoa703.service.MbtiTypeDelete;
import com.thejoa703.service.MbtiTypeInsert;
import com.thejoa703.service.MbtiTypeSelect;
import com.thejoa703.service.MbtiTypeSelectAll;
import com.thejoa703.service.MbtiTypeService;
import com.thejoa703.service.MbtiTypeUpdate;

@WebServlet("*.mbti")
public class MbtiTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MbtiTypeController() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doMbitType(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doMbitType(request, response);
	}

	protected void doMbitType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //각경로 호출되는지 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String path = request.getServletPath();
		
		MbtiTypeService service = null; //##
		    
		if(path.equals("/regForm.mbti")) {  //처리x
			request.getRequestDispatcher("/mbtiType/write.jsp").forward(request, response); 
		}else if(path.equals("/reg.mbti")) {
			service = new MbtiTypeInsert();  service.exec(request, response);
			String result  =  (String) request.getAttribute("result");
			if(result.equals("1")) { out.println("<script>alert('등록했습니다.'); location.href='mbtiAll.mbti'; </script>"); }
			else { out.println("<script>alert('관리자에게 문의해주세요'); history.go(-1); </script>"); }
		}else if(path.equals("/mbtiAll.mbti")) { 
			service = new MbtiTypeSelectAll();  service.exec(request, response);
			request.getRequestDispatcher("/mbtiType/list.jsp").forward(request, response);
		}else if(path.equals("/mbti.mbti")) {
			service = new MbtiTypeSelect();  service.exec(request, response);
			request.getRequestDispatcher("/mbtiType/detail.jsp").forward(request, response);
		}else if(path.equals("/updateForm.mbti")) {
			service = new MbtiTypeSelect();  service.exec(request, response);
			request.getRequestDispatcher("/mbtiType/edit.jsp").forward(request, response);
		}else if(path.equals("/update.mbti")) {
			service = new MbtiTypeUpdate();  service.exec(request, response);
			String result  =  (String) request.getAttribute("result");
			int id = Integer.parseInt(request.getParameter("id"));
			if(result.equals("1")) { out.println("<script>alert('수정했습니다.'); location.href='mbti.mbti?id="+id+"'; </script>"); }
			else { out.println("<script>alert('관리자에게 문의해주세요'); history.go(-1); </script>"); }
		}else if(path.equals("/delete.mbti")) { 
			service = new MbtiTypeDelete();  service.exec(request, response);
			String result  =  (String) request.getAttribute("result");
			if(result.equals("1")) { out.println("<script>alert('삭제했습니다.'); location.href='mbtiAll.mbti'; </script>"); }
			else { out.println("<script>alert('관리자에게 문의해주세요'); history.go(-1); </script>"); }
		}
	}
}

//ㄴindex.jsp
//ㄴ  [등록폼]			  /regForm.mbti	   □		/mbtitype/write.jsp	
//ㄴ  [등록기능]         /reg.mbti		   ■ insert()	/mbtiAll.mbti
//ㄴ  [전체보기]         /mbtiAll.mbti	   ■ selectAll()       /mbtitype/list.jsp	
//ㄴ  [상세보기]         /mbti.mbti	   ■ select()          /mbtitype/detail.jsp	
//ㄴ  [수정폼]            /updateForm.mbti     ■ updateForm()	/mbtitype/edit.jsp	
//ㄴ  [수정기능]         /update.mbti            ■ update()	 /mbti.mbti  해당번호의 글이 바로 수정
//ㄴ  [삭제기능]         /delete.mbti             ■ delete()	 /mbtiAll.mbti     