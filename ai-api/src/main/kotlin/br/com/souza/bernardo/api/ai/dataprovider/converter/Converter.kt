package br.com.souza.bernardo.api.ai.dataprovider.converter

import br.com.souza.bernardo.api.ai.core.domain.Chat
import br.com.souza.bernardo.api.ai.core.domain.ChatMessage
import br.com.souza.bernardo.api.ai.dataprovider.domain.ChatDocument
import br.com.souza.bernardo.api.ai.dataprovider.domain.ChatMessageDocument
import org.mapstruct.Mapper
import org.mapstruct.MapperConfig

interface BaseConverter <ENTITY, RESPONSE> {
    fun convertFromEntity(entity: ENTITY): RESPONSE
    fun convertToEntity(response: RESPONSE): ENTITY
}

@Mapper(componentModel = "spring", uses = [MapperConfig::class])
interface ChatConverter: BaseConverter<ChatDocument, Chat>

@Mapper(componentModel = "spring", uses = [MapperConfig::class])
interface ChatMessageConverter : BaseConverter<ChatMessageDocument, ChatMessage> {
    fun convertListToEntity(messages: List<ChatMessage>): List<ChatMessageDocument>
}
