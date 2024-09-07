package br.com.souza.bernardo.api.ai.dataprovider.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*


@Document(collection = "chat")
data class ChatDocument(
    @Id
    val id: String,
    val user: UUID,
    val history: List<ChatMessageDocument> = emptyList()
)
