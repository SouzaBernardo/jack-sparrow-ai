package br.com.souza.bernardo.api.ai.core.usecase

import br.com.souza.bernardo.api.ai.core.request.QuestionRequest
import br.com.souza.bernardo.api.ai.core.response.ChatResponse

interface DoQuestion {
    suspend fun question(request: QuestionRequest): List<ChatResponse>
}