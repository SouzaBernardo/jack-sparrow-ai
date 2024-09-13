package br.com.souza.bernardo.api.ai.dataprovider.converter

import br.com.souza.bernardo.api.ai.core.domain.Chat
import br.com.souza.bernardo.api.ai.dataprovider.domain.ChatDocument
import org.mapstruct.Mapper

@Mapper
interface ChatConverter: BaseConverter<ChatDocument, Chat> {
}