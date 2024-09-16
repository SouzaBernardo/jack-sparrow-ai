package br.com.souza.bernardo.api.ai.application.service

import br.com.souza.bernardo.api.ai.application.converter.ChatConverter
import br.com.souza.bernardo.api.ai.core.domain.Chat
import br.com.souza.bernardo.api.ai.core.domain.ChatMessage
import br.com.souza.bernardo.api.ai.core.gateway.CrudChatGateway
import br.com.souza.bernardo.api.ai.dataprovider.repository.ChatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CrudChatService(
    @Autowired private val chatRepository: ChatRepository,
    @Autowired private val chatConverter: ChatConverter
) : CrudChatGateway {

    override fun findChatByUserId(userId: UUID): Chat {
        val chat = chatRepository.findByUser(userId) ?: return Chat(null, userId, emptyList())
        return chatConverter.convert(chat)
    }

    override suspend fun save(entity: Chat, chatMessage: List<ChatMessage>): Chat {
        return chatConverter.convert(withContext(Dispatchers.IO) {
            chatRepository.save(chatConverter.convert(entity))
        })
    }
}