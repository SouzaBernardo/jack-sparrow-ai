package br.com.souza.bernardo.api.ai.request

import org.jetbrains.annotations.NotNull

data class SendMessageRequest(
    @NotNull
    val message: String
)
