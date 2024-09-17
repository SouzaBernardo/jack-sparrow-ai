package br.com.souza.bernardo.api.ai.dataprovider.converter

import br.com.souza.bernardo.api.ai.core.domain.Chat
import br.com.souza.bernardo.api.ai.dataprovider.domain.ChatDocument
import org.mapstruct.Mapper
import org.mapstruct.MapperConfig

@Mapper(componentModel = "spring", uses = [MapperConfig::class])
interface ChatConverter: BaseConverter<ChatDocument, Chat>
