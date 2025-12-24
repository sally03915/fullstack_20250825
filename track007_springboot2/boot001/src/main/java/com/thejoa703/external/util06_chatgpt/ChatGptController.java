package com.thejoa703.external.util06_chatgpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatGptController {

    @Autowired
    private ChatGptService chatGptService;

    @GetMapping("/chatbot")
    public String chatbot_1() {
        return "external/chatbot";
    }

  @GetMapping("/api/openai")
  public String chatbot() {
      return "external/openai";
  }
    
    @PostMapping(value = "/api/openai", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String openai(@RequestBody String content) {
        return chatGptService.getAIResponse(content);
    }
}


/*

curl -X POST http://localhost:8484/api/openai -H "Content-Type: application/json" -d "오늘 하루가 좀 벅찼지만 친구와 저녁 먹고 기분이 좋아졌다"


*/