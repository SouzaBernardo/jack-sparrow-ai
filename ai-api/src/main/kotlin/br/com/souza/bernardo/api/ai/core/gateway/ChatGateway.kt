package br.com.souza.bernardo.api.ai.core.gateway

import br.com.souza.bernardo.api.ai.core.response.ChatResponse
import br.com.souza.bernardo.api.ai.core.usecase.DoQuestion

interface ChatGateway: DoQuestion<String, ChatResponse> {
    override fun question(input: String): ChatResponse
}