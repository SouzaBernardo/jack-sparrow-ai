package br.com.souza.bernardo.api.ai.entrypoint.chat

import br.com.souza.bernardo.api.ai.core.gateway.QuestionGateway
import br.com.souza.bernardo.api.ai.core.request.QuestionRequest
import br.com.souza.bernardo.api.ai.core.response.ChatResponse
import br.com.souza.bernardo.api.ai.core.response.UserResponse
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/v1/chat")
class ChatController(@Autowired private val chatService: QuestionGateway) {

    @PostMapping
    suspend fun question(@Valid @RequestBody request: QuestionRequest): List<ChatResponse> =
        chatService.question(request.message, request.userId)

    @GetMapping("/user")
    fun getUser(): UserResponse = UserResponse(UUID.randomUUID())
}