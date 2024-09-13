package br.com.souza.bernardo.api.ai.core.usecase

import java.util.*

interface DoQuestion<INPUT, OUTPUT> {
    suspend fun question(input: INPUT, userId: UUID): OUTPUT
}