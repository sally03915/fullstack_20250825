package com.thejoa703.external.util02_naver_book.copy;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NaberbooksController {
 
	@Autowired    NaverBooks api;
	
	@GetMapping("/naver/books")
	public String books() { return "external/books";}  //  books.html
	
	@GetMapping(value="/naver/booksapi/{search}" , produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String booksJson( @PathVariable String search ) throws IOException {
		return  api.getApi(search);
	}
	///////////////////////////////////////////
	/*
	@GetMapping("/naver/books2")
	public String books2() { return "external/books2";}  //  books.html
	
    @GetMapping("/naver/booksapi2/{search}")
    @ResponseBody
    public ResponseEntity<String> booksJson2(@PathVariable String search) throws IOException {
        String result = api.getApi(search);
        return ResponseEntity.ok()
                .header("Content-Type", "application/json;charset=UTF-8")
                .body(result);
    }*/
}







