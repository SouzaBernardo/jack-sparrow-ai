package br.com.souza.bernardo.api.ai.application.service

import br.com.souza.bernardo.api.ai.core.gateway.ChatGateway
import br.com.souza.bernardo.api.ai.core.gateway.PromptGateway
import br.com.souza.bernardo.api.ai.core.response.ChatResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ChatService(
    @Autowired
    private val promptService: PromptGateway
) : ChatGateway {
    override fun question(input: String): ChatResponse = ChatResponse(promptService.execute(input))
}