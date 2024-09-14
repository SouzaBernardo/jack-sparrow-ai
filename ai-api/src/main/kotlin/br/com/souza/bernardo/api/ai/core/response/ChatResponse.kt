package br.com.souza.bernardo.api.ai.core.response

import br.com.souza.bernardo.api.ai.core.domain.ChatOrigin

data class ChatResponse(val message: String, val origin: ChatOrigin)
