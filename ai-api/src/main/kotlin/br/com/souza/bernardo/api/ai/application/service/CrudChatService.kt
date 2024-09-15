package br.com.souza.bernardo.api.ai.application.service

import br.com.souza.bernardo.api.ai.core.domain.Chat
import br.com.souza.bernardo.api.ai.core.domain.ChatMessage
import br.com.souza.bernardo.api.ai.core.gateway.CrudChatGateway
import br.com.souza.bernardo.api.ai.dataprovider.domain.ChatDocument
import br.com.souza.bernardo.api.ai.dataprovider.domain.ChatMessageDocument
import br.com.souza.bernardo.api.ai.dataprovider.repository.ChatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CrudChatService(
    @Autowired
    private val chatRepository: ChatRepository
) : CrudChatGateway {

    override fun findChatByUserId(userId: UUID): Chat {
        val chat = chatRepository.findByUser(userId) ?: return Chat(null, userId, emptyList())
        return Chat(chat.id, chat.user, chat.history.convertHistory())
    }

    override suspend fun save(entity: Chat, chatMessage: List<ChatMessage>): Chat {
        return withContext(Dispatchers.IO) {
            chatRepository.save(entity.convertToEntity())
        }.convertToEntity()

    }
}

fun Chat.convertToEntity(): ChatDocument = ChatDocument(id, user, history.convertToHistoryDocument())

fun ChatDocument.convertToEntity(): Chat = Chat(id!!, user, history.convertHistory())

fun List<ChatMessage>.convertToHistoryDocument(): List<ChatMessageDocument> =
    map { ChatMessageDocument(it.message, it.origin) }

fun List<ChatMessageDocument>.convertHistory(): List<ChatMessage> = map { ChatMessage(it.message, it.origin) }
