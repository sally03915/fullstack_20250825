package com.thejoa703.external.util04_crawling;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;   // 누락된 부분
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class Api_Jsoup1 {
  
	public List<SongDto> jsoup1() {
	    List<SongDto> list = new ArrayList<>();
	    try {
	        String url = "https://www.melon.com/chart/index.htm";
	        Connection conn = Jsoup.connect(url)
	                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
	                .referrer("https://www.melon.com/")
	                .timeout(10_000);

	        Document doc = conn.get();

	        Elements titleElems = doc.select("div.ellipsis.rank01 a");
	        Elements artistElems = doc.select("div.ellipsis.rank02 a");

	        int count = Math.min(titleElems.size(), artistElems.size());
	        for (int i = 0; i < count; i++) {
	            String title = titleElems.get(i).text();
	            String artist = artistElems.get(i).text();
	            list.add(new SongDto(title, artist));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        list.add(new SongDto("크롤링 중 오류 발생", e.getMessage()));
	    }
	    return list;
	}
 
    
}
