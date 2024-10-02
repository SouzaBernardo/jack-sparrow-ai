package br.com.souza.bernardo.api.ai.core.request

import br.com.souza.bernardo.api.ai.core.domain.ChatOrigin


data class OldMessage(val message: String, val origin: ChatOrigin)