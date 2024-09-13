package br.com.souza.bernardo.api.ai.core.gateway

import br.com.souza.bernardo.api.ai.core.response.ChatResponse
import br.com.souza.bernardo.api.ai.core.usecase.DoQuestion
import java.util.*

interface QuestionGateway: DoQuestion<String, List<ChatResponse>> {
    override suspend fun question(input: String, userId: UUID): List<ChatResponse>
}