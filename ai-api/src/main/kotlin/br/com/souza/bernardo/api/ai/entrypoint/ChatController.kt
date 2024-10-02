package br.com.souza.bernardo.api.ai.entrypoint

import br.com.souza.bernardo.api.ai.core.gateway.QuestionGateway
import br.com.souza.bernardo.api.ai.core.request.QuestionRequest
import br.com.souza.bernardo.api.ai.core.response.UserResponse
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/v1/chat")
class ChatController(@Autowired private val questionGateway: QuestionGateway) {

    @PostMapping
    suspend fun question(@Valid @RequestBody request: QuestionRequest) = questionGateway.question(request)

    @GetMapping("/user")
    fun getUser(): UserResponse = UserResponse(UUID.randomUUID())
}