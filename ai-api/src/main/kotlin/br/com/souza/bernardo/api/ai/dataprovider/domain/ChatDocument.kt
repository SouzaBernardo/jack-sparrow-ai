package br.com.souza.bernardo.api.ai.dataprovider.domain

import br.com.souza.bernardo.api.ai.core.domain.ChatOrigin
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "chat")
data class ChatDocument(
    @Id
    val id: String? = null,
    val user: UUID,
    val history: List<ChatMessageDocument> = emptyList()
)

data class ChatMessageDocument(
    val message: String,
    val origin: ChatOrigin
)
