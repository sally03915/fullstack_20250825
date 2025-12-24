package com.thejoa703.external.util02_naver_book;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Service
public class NaverBooksXmlService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final XmlMapper xmlMapper = new XmlMapper();

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Channel {
        @JacksonXmlProperty(localName = "item")
        @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper(useWrapping = false)
        private List<BookDto> items;

        public List<BookDto> getItems() { return items; }
        public void setItems(List<BookDto> items) { this.items = items; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Rss {
        @JacksonXmlProperty(localName = "channel")
        private Channel channel;

        public Channel getChannel() { return channel; }
        public void setChannel(Channel channel) { this.channel = channel; }
    }

    public List<BookDto> getBooks(String query) throws UnsupportedEncodingException {
        String clientId = "reu63fdeQl8IXmwLVsRM";   // ##
        String clientSecret = "AvEnm8FcX2";         // ##
        String param = "?query=" + URLEncoder.encode(query, "UTF-8");
        String url = "https://openapi.naver.com/v1/search/book.xml" + param;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);
        headers.set("Accept", "application/xml");

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        try {
            // XML 응답을 Rss → Channel → Item 구조로 파싱
            Rss rss = xmlMapper.readValue(response.getBody(), Rss.class);
            return rss.getChannel().getItems();
        } catch (Exception e) {
            throw new RuntimeException("XML 파싱 오류", e);
        }
    }
}
