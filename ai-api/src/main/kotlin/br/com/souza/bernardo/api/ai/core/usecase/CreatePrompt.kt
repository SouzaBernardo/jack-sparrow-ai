package br.com.souza.bernardo.api.ai.core.usecase

import org.springframework.ai.chat.prompt.Prompt

interface CreatePrompt<INPUT> {
    fun create(input: INPUT): Prompt
}