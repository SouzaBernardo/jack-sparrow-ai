package br.com.souza.bernardo.api.ai.core.usecase

interface DoQuestion<INPUT, OUTPUT> {
    fun question(input: INPUT): OUTPUT
}