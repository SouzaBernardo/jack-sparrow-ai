package br.com.souza.bernardo.api.ai.core.usecase

import br.com.souza.bernardo.api.ai.core.domain.ChatMessage

interface ExecutePrompt<OUTPUT> {
    fun execute(input: String, oldMessages: List<ChatMessage>): OUTPUT
}