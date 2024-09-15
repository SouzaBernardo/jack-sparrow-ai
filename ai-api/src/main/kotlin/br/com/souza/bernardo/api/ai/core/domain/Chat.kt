package br.com.souza.bernardo.api.ai.core.domain

import org.springframework.ai.chat.messages.MessageType
import java.util.*

private const val NUMBER_OF_MESSAGES = 3

data class Chat(
    val id: String? = null,
    val user: UUID,
    val history: List<ChatMessage> = emptyList()
) {
    fun lastMessages(): List<ChatMessage> {
        return if (history.size < NUMBER_OF_MESSAGES) history
        else history.subList(history.size - NUMBER_OF_MESSAGES, history.size)
    }
}

enum class ChatOrigin(val type: MessageType) {
    USER(MessageType.USER), AI(MessageType.ASSISTANT)
}
