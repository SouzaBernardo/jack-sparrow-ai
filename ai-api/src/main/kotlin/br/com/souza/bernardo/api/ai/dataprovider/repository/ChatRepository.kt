package br.com.souza.bernardo.api.ai.dataprovider.repository

import br.com.souza.bernardo.api.ai.dataprovider.domain.ChatDocument
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface ChatRepository: MongoRepository<ChatDocument, String> {
    fun findByUser(user: UUID): ChatDocument?
}