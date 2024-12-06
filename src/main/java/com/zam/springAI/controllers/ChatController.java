package com.zam.springAI.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ChatController.API_PATH)
public class ChatController {

    public static final String API_PATH = "/api/chat";

    private final ChatClient chatClient;

    @Autowired
    public ChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping
    public ResponseEntity<?> senMessage(@RequestParam String message) {
        return new ResponseEntity<>(chatClient.prompt(message).call(), HttpStatus.OK);
    }

}
