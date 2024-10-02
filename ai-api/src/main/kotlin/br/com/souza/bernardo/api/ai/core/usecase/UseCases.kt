package br.com.souza.bernardo.api.ai.core.usecase

import br.com.souza.bernardo.api.ai.core.domain.Chat
import br.com.souza.bernardo.api.ai.core.domain.ChatMessage
import br.com.souza.bernardo.api.ai.core.request.QuestionRequest
import br.com.souza.bernardo.api.ai.core.response.ChatResponse
import org.springframework.ai.chat.prompt.Prompt
import java.util.*

interface CreatePrompt {
    fun create(input: String, oldMessages: List<ChatMessage>): Prompt
}

interface DoQuestion {
    fun question(request: QuestionRequest): List<ChatResponse>
}

interface ExecutePrompt {
    fun execute(input: String, oldMessages: List<ChatMessage>): String
}

interface FindChatByUserId {
    fun findChatByUserId(userId: UUID): Chat
}

interface SaveChat {
    fun save(chat: Chat, chatMessage: List<ChatMessage>)
}