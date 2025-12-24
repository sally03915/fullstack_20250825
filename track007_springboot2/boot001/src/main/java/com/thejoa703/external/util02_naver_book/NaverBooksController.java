package com.thejoa703.external.util02_naver_book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;   // produces 옵션에 필요

import java.io.UnsupportedEncodingException;
import java.util.List;


@RestController
@RequestMapping("/naver/booksapi")
public class NaverBooksController {

    @Autowired
    private NaverBooksJsonService jsonService;

    @Autowired
    private NaverBooksXmlService xmlService;

    // JSON 버전
    @GetMapping(value = "/json/{search}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDto> booksJson(@PathVariable String search) throws UnsupportedEncodingException {
        return jsonService.getBooks(search);
    }

    // XML 버전
    @GetMapping(value = "/xml/{search}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDto> booksXml(@PathVariable String search) throws UnsupportedEncodingException {
        return xmlService.getBooks(search);
    }
}
