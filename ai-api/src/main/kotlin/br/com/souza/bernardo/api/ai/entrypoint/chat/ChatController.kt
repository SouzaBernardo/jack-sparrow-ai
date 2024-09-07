package br.com.souza.bernardo.api.ai.entrypoint.chat

import br.com.souza.bernardo.api.ai.core.gateway.QuestionGateway
import br.com.souza.bernardo.api.ai.core.request.QuestionRequest
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/chat")
class ChatController(@Autowired private val chatService: QuestionGateway) {
    @PostMapping
    fun question(@Valid @RequestBody request: QuestionRequest) =
        chatService.question(request.message)
}