package br.com.souza.bernardo.api.ai.core.domain

import org.springframework.ai.chat.messages.MessageType
import java.util.*

data class Chat(
    val id: String? = null,
    val user: UUID,
    val history: List<ChatMessage> = emptyList()
) {
    fun userMessages(): List<ChatMessage> = history.filter {
        MessageType.USER.value.equals(it.origin)
    }

    fun systemMessages(): List<ChatMessage> = history.filter {
        MessageType.ASSISTANT.value.equals(it.origin)
    }


}
