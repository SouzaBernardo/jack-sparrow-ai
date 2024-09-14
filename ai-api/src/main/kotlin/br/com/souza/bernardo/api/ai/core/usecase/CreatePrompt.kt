package br.com.souza.bernardo.api.ai.core.usecase

import br.com.souza.bernardo.api.ai.core.request.OldMessages
import org.springframework.ai.chat.prompt.Prompt

interface CreatePrompt<INPUT> {
    fun create(input: INPUT, oldMessages: OldMessages?): Prompt
}