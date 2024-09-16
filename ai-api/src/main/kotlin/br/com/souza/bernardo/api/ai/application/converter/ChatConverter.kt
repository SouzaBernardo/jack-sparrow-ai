package br.com.souza.bernardo.api.ai.application.converter

import br.com.souza.bernardo.api.ai.core.domain.Chat
import br.com.souza.bernardo.api.ai.core.domain.ChatMessage
import br.com.souza.bernardo.api.ai.core.domain.ChatOrigin
import br.com.souza.bernardo.api.ai.dataprovider.domain.ChatDocument
import br.com.souza.bernardo.api.ai.dataprovider.domain.ChatMessageDocument
import org.mapstruct.Mapper
import org.springframework.ai.chat.messages.AssistantMessage
import org.springframework.ai.chat.messages.Message
import org.springframework.ai.chat.messages.UserMessage
import org.springframework.stereotype.Component

@Mapper
@Component
interface ChatConverter: BaseConverter<ChatDocument, Chat> {
}

fun List<ChatMessage>.toAiMessages(): List<Message> = map {
    return@map if (ChatOrigin.AI == it.origin) AssistantMessage(it.message)
    else UserMessage(it.message)
}

fun List<ChatMessage>.convertToHistoryDocument(): List<ChatMessageDocument> =
    map { ChatMessageDocument(it.message, it.origin) }

fun List<ChatMessageDocument>.convertHistory(): List<ChatMessage> = map { ChatMessage(it.message, it.origin) }
