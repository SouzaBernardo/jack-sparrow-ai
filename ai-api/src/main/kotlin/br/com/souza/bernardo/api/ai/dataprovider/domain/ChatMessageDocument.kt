package br.com.souza.bernardo.api.ai.dataprovider.domain

import br.com.souza.bernardo.api.ai.core.domain.ChatOrigin

data class ChatMessageDocument(
    val message: String,
    val origin: ChatOrigin
)
