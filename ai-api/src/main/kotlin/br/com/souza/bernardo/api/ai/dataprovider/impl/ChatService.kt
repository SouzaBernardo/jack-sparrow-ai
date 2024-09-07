package br.com.souza.bernardo.api.ai.dataprovider.impl

import br.com.souza.bernardo.api.ai.core.domain.Chat
import br.com.souza.bernardo.api.ai.core.usecase.SaveChat
import br.com.souza.bernardo.api.ai.dataprovider.converter.ChatConverter
import br.com.souza.bernardo.api.ai.dataprovider.domain.ChatDocument

class ChatService(
    private val chatConverter: ChatConverter
) : SaveChat<ChatDocument, Chat> {

    override fun save(entity: ChatDocument): Chat {
        TODO("Not yet implemented")
    }

}