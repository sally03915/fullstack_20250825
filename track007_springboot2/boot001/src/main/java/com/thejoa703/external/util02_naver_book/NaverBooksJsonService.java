package com.thejoa703.external.util02_naver_book;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class NaverBooksJsonService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<BookDto> getBooks(String query) throws UnsupportedEncodingException {
        String clientId = "reu63fdeQl8IXmwLVsRM";   // ##
        String clientSecret = "AvEnm8FcX2";         // ##
        String param = "?query=" + URLEncoder.encode(query, "UTF-8");
        String url = "https://openapi.naver.com/v1/search/book.json" + param;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        List<BookDto> result = new ArrayList<>();
        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            for (JsonNode item : root.path("items")) {
                BookDto book = new BookDto();
                book.setTitle(item.path("title").asText());
                book.setImage(item.path("image").asText());
                book.setAuthor(item.path("author").asText());
                result.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
