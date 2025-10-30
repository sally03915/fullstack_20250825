package com.thejoa703.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MbtiInsert implements MbtiService {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1. 데이터넘겨받고
		//2. 디커프리( PostDao ) db처리
	}
}
