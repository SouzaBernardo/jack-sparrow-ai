package br.com.souza.bernardo.api.ai.controller

import br.com.souza.bernardo.api.ai.request.SendMessageRequest
import br.com.souza.bernardo.api.ai.service.ChatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/chat")
class ChatController(
    @Autowired
    private val chatService: ChatService
) {
    @PostMapping
    fun sendMessage(@Validated @RequestBody request: SendMessageRequest) =
        chatService.send(request.message)
}