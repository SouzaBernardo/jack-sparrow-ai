package br.com.souza.bernardo.api.ai.core.usecase

interface DoQuestion<INPUT, OUTPUT> {
    suspend fun question(request: INPUT): OUTPUT
}