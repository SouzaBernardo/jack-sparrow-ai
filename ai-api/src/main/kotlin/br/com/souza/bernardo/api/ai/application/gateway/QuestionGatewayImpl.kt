package br.com.souza.bernardo.api.ai.application.gateway

import br.com.souza.bernardo.api.ai.core.domain.ChatMessage
import br.com.souza.bernardo.api.ai.core.domain.ChatOrigin
import br.com.souza.bernardo.api.ai.core.gateway.CrudChatGateway
import br.com.souza.bernardo.api.ai.core.gateway.PromptGateway
import br.com.souza.bernardo.api.ai.core.gateway.QuestionGateway
import br.com.souza.bernardo.api.ai.core.request.QuestionRequest
import br.com.souza.bernardo.api.ai.core.response.ChatResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class QuestionGatewayImpl(
    @Autowired
    private val promptService: PromptGateway,
    @Autowired
    private val crudChatGateway: CrudChatGateway
) : QuestionGateway {

    override fun question(request: QuestionRequest): List<ChatResponse> {
        val chat = crudChatGateway.findChatByUserId(request.userId)
        val message = promptService.execute(request.message, chat.lastMessages())
        val userMessage = ChatMessage(request.message, ChatOrigin.USER)
        val chatResponse = ChatMessage(message, ChatOrigin.AI)
        val chatHistory = chat.history
            .plus(userMessage)
            .plus(chatResponse)
        crudChatGateway.save(chat, chatHistory)
        return toResponse(chatHistory)
    }

    fun toResponse(history: List<ChatMessage>): List<ChatResponse> {
        return history.map { ChatResponse(it.message, it.origin) }
    }
}