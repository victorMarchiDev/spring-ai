package com.github.victorMarchiDev.spring_ai.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatModel chatModel;

    public ChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getResponse(String prompt){
        return chatModel.call(prompt);
    }
}
