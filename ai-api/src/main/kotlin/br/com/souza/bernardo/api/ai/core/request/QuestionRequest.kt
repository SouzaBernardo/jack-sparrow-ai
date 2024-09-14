package br.com.souza.bernardo.api.ai.core.request

import br.com.souza.bernardo.api.ai.core.domain.ChatOrigin
import jakarta.validation.constraints.NotBlank
import org.springframework.ai.chat.messages.AssistantMessage
import org.springframework.ai.chat.messages.Message
import org.springframework.ai.chat.messages.UserMessage
import org.springframework.ai.chat.prompt.PromptTemplate
import java.util.*


typealias OldMessages = ArrayList<OldMessage>

fun OldMessages.getHistory(): List<Message> = map {
    val response = PromptTemplate(it.message).createMessage()
    if (it.origin == ChatOrigin.AI) return@map response as AssistantMessage
    else return@map response as UserMessage
}

data class QuestionRequest(
    @NotBlank val message: String,
    @NotBlank val userId: UUID,
    val oldMessages: OldMessages? = null
)
