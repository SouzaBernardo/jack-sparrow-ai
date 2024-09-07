package br.com.souza.bernardo.api.ai.core.usecase

interface ExecutePrompt<OUTPUT> {
    fun execute(input: String): OUTPUT
}