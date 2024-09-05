package br.com.souza.bernardo.api.ai.service

import br.com.souza.bernardo.api.ai.response.ChatResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ChatService(
    @Autowired
    private val promptService: PromptService
) {
    fun send(message: String): ChatResponse = ChatResponse(promptService.question(message))
}