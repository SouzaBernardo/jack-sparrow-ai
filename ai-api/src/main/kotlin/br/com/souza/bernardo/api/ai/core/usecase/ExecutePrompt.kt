package br.com.souza.bernardo.api.ai.core.usecase

import br.com.souza.bernardo.api.ai.core.request.OldMessages

interface ExecutePrompt<OUTPUT> {
    fun execute(input: String, oldMessages: OldMessages?): OUTPUT
}