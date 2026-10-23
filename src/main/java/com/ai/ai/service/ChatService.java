package com.ai.ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatService {

    @Autowired
    private ChatClient chatClient;

    public Flux<String> streamChatResponse(String userMessage){  // 리액티브 스트림으로 토큰 단위 실시간 응답 반환
        Message message = UserMessage.builder().text(userMessage).build();
        return chatClient.prompt().messages(message).stream().content();
    }
}
