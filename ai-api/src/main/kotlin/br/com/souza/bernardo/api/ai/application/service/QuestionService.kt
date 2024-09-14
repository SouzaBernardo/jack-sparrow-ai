package br.com.souza.bernardo.api.ai.application.service

import br.com.souza.bernardo.api.ai.core.domain.ChatMessage
import br.com.souza.bernardo.api.ai.core.domain.ChatOrigin
import br.com.souza.bernardo.api.ai.core.gateway.CrudChatGateway
import br.com.souza.bernardo.api.ai.core.gateway.PromptGateway
import br.com.souza.bernardo.api.ai.core.gateway.QuestionGateway
import br.com.souza.bernardo.api.ai.core.request.QuestionRequest
import br.com.souza.bernardo.api.ai.core.response.ChatResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class QuestionService(
    @Autowired
    private val promptService: PromptGateway,
    @Autowired
    private val crudChatGateway: CrudChatGateway
) : QuestionGateway {

    override suspend fun question(request: QuestionRequest): List<ChatResponse> {

        val message = promptService.execute(request.message, request.oldMessages)
        val chat = crudChatGateway.findChatByUserId(request.userId)
        val chatHistory = chat.history
            .plus(ChatMessage(request.message, ChatOrigin.USER))
            .plus(ChatMessage(message, ChatOrigin.AI))

        val newChat = withContext(Dispatchers.IO) {
            crudChatGateway.save(chat, chatHistory)
        }

        return toResponse(newChat.history)
    }

    fun toResponse(history: List<ChatMessage>): List<ChatResponse> {
        return history.map { ChatResponse(it.message, it.origin) }
    }
}