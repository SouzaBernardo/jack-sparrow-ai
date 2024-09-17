package br.com.souza.bernardo.api.ai.core.usecase

import br.com.souza.bernardo.api.ai.core.domain.Chat
import br.com.souza.bernardo.api.ai.core.domain.ChatMessage

interface SaveChat {
    suspend fun save(chat: Chat, chatMessage: List<ChatMessage>)
}