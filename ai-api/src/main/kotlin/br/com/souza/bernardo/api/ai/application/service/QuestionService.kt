package br.com.souza.bernardo.api.ai.application.service

import br.com.souza.bernardo.api.ai.core.domain.ChatMessage
import br.com.souza.bernardo.api.ai.core.gateway.CrudChatGateway
import br.com.souza.bernardo.api.ai.core.gateway.PromptGateway
import br.com.souza.bernardo.api.ai.core.gateway.QuestionGateway
import br.com.souza.bernardo.api.ai.core.response.ChatResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class QuestionService(
    @Autowired
    private val promptService: PromptGateway,
    @Autowired
    private val crudChatGateway: CrudChatGateway
) : QuestionGateway {
    override suspend fun question(input: String, userId: UUID): List<ChatResponse> {

        val message = promptService.execute(input)
        val origin = "AI"

        val chat = crudChatGateway.findChatByUserId(userId)
        val chatHistory = chat.history
            .plus(ChatMessage(input, "USER"))
            .plus(ChatMessage(message, origin))

        val newChat = withContext(Dispatchers.IO) {
            crudChatGateway.save(chat, chatHistory)
        }

        return toResponse(newChat.history)
    }

    fun toResponse(history: List<ChatMessage>): List<ChatResponse> {
        return history.map { ChatResponse(it.message, it.origin) }
    }
}