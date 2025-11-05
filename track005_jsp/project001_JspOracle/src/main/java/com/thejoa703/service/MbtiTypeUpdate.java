package com.thejoa703.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thejoa703.dao.MbtiDao;
import com.thejoa703.dto.MbtiDto;

public class MbtiTypeUpdate implements MbtiTypeService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 데이터 받기
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String desc = request.getParameter("description");
		int id = Integer.parseInt(  request.getParameter("id")  );
		//2. 드커프리
        MbtiDao dao = new MbtiDao();
        MbtiDto dto = new MbtiDto();
        dto.setName(name);
	    dto.setDescription(desc); 
	    dto.setMbtiTypeId(id);
		//3. 데이터 넘기기
	    request.setAttribute("result",  String.valueOf(dao.update(dto)));
	}

}

/*
		◆  MbtiTypeService<<interface>>
			△......... MbtiTypeInsert       등록기능    / insert()
			△......... MbtiTypeSelectAll   전체보기    / selectAll() 
			△......... MbtiTypeSelect       상세보기,수정폼    / select()  
			△......... MbtiTypeUpdate     수정기능              / update() 
			△......... MbtiTypeDelete       삭제기능            / delete() 
*/