package br.com.souza.bernardo.api.ai.core.usecase

import br.com.souza.bernardo.api.ai.core.domain.ChatMessage
import org.springframework.ai.chat.prompt.Prompt

interface CreatePrompt {
    fun create(input: String, oldMessages: List<ChatMessage>): Prompt
}