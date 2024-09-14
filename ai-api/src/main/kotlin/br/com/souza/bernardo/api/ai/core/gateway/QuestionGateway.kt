package br.com.souza.bernardo.api.ai.core.gateway

import br.com.souza.bernardo.api.ai.core.request.QuestionRequest
import br.com.souza.bernardo.api.ai.core.response.ChatResponse
import br.com.souza.bernardo.api.ai.core.usecase.DoQuestion

interface QuestionGateway: DoQuestion<QuestionRequest, List<ChatResponse>> {
    override suspend fun question(request: QuestionRequest): List<ChatResponse>
}