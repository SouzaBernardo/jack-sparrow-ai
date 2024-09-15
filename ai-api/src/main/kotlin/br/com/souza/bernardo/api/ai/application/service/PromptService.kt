package br.com.souza.bernardo.api.ai.application.service

import br.com.souza.bernardo.api.ai.core.domain.ChatMessage
import br.com.souza.bernardo.api.ai.core.domain.ChatOrigin
import br.com.souza.bernardo.api.ai.core.gateway.PromptGateway
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.messages.AssistantMessage
import org.springframework.ai.chat.messages.Message
import org.springframework.ai.chat.messages.UserMessage
import org.springframework.ai.chat.prompt.ChatOptionsBuilder
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils


@Service
class PromptService(
    @Autowired private val chatClient: ChatClient.Builder,
    @Autowired private val assistantMessage: AssistantMessage
) : PromptGateway {

    override fun create(input: String, oldMessages: List<ChatMessage>): Prompt {
        val messages: List<Message> = messages(input, oldMessages)
        return Prompt(messages, ChatOptionsBuilder.builder().build())
    }

    private fun messages(input: String, oldMessages: List<ChatMessage>): List<Message> {
        if (CollectionUtils.isEmpty(oldMessages)) {
            return listOf(assistantMessage, UserMessage(input))
        }
        val start: List<Message> = listOf(assistantMessage)
        val context: List<Message> = start.plus(oldMessages.toMessages())
        return context.plus(UserMessage(input))
    }

    override fun execute(input: String, oldMessages: List<ChatMessage>): String = chatClient
        .build()
        .prompt(create(input, oldMessages)).call().chatResponse()
        .result.output.content
}

fun List<ChatMessage>.toMessages(): List<Message> = map {
    return@map if (ChatOrigin.AI == it.origin) AssistantMessage(it.message)
    else UserMessage(it.message)
}
