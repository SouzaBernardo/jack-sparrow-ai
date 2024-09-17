package br.com.souza.bernardo.api.ai.core.domain

import org.springframework.ai.chat.messages.Message

data class ChatMessage(
    val message: String,
    val origin: ChatOrigin
) {
    fun getAiMessage(): Message {
        return origin.message(message)
    }
}