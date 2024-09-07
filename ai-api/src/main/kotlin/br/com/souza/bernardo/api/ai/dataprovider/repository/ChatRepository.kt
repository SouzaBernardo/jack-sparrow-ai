package br.com.souza.bernardo.api.ai.dataprovider.repository

import br.com.souza.bernardo.api.ai.dataprovider.domain.ChatDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ChatRepository: ReactiveMongoRepository<ChatDocument, String> {
}