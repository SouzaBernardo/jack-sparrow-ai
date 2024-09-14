package br.com.souza.bernardo.api.ai.core.domain

import org.springframework.ai.chat.messages.MessageType
import java.util.*

data class Chat(
    val id: String? = null,
    val user: UUID,
    val history: List<ChatMessage> = emptyList()
)

enum class ChatOrigin(val type: MessageType) {
    USER(MessageType.USER), AI(MessageType.ASSISTANT)
}
