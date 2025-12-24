package com.thejoa703.external.util02_naver_book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)   // 알 수 없는 필드는 무시
@JacksonXmlRootElement(localName = "item")   // XML <item> 루트 매핑
public class BookDto {
    @JsonProperty("title")
    @JacksonXmlProperty(localName = "title")
    private String title;

    @JsonProperty("image")
    @JacksonXmlProperty(localName = "image")
    private String image;

    @JsonProperty("author")
    @JacksonXmlProperty(localName = "author")
    private String author;

    public BookDto() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}
