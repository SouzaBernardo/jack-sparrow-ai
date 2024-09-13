package br.com.souza.bernardo.api.ai.core.usecase

import br.com.souza.bernardo.api.ai.core.domain.Chat
import java.util.*

interface FindChatByUserId {
    fun findChatByUserId(userId: UUID): Chat
}