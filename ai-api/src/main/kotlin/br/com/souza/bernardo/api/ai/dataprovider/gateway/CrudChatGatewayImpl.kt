package br.com.souza.bernardo.api.ai.dataprovider.gateway

import br.com.souza.bernardo.api.ai.core.domain.Chat
import br.com.souza.bernardo.api.ai.core.domain.ChatMessage
import br.com.souza.bernardo.api.ai.core.gateway.CrudChatGateway
import br.com.souza.bernardo.api.ai.dataprovider.converter.ChatConverter
import br.com.souza.bernardo.api.ai.dataprovider.converter.ChatMessageConverter
import br.com.souza.bernardo.api.ai.dataprovider.domain.ChatDocument
import br.com.souza.bernardo.api.ai.dataprovider.repository.ChatRepository
import kotlinx.coroutines.runBlocking
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CrudChatGatewayImpl(
    @Autowired private val chatRepository: ChatRepository,
    val chatConverter: ChatConverter = Mappers.getMapper(ChatConverter::class.java),
    val chatMessageConverter: ChatMessageConverter = Mappers.getMapper(ChatMessageConverter::class.java),
) : CrudChatGateway {

    override fun findChatByUserId(userId: UUID): Chat {
        val chat = chatRepository.findByUser(userId) ?: return Chat(null, userId, emptyList())
        return chatConverter.convertFromEntity(chat)
    }

    override suspend fun save(chat: Chat, chatMessage: List<ChatMessage>) {
        runBlocking {
            val entity = ChatDocument(chat.id, chat.user, chatMessageConverter.convertListToEntity(chatMessage))
            chatRepository.save(entity)
        }
    }
}