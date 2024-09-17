package br.com.souza.bernardo.api.ai.application.gateway

import br.com.souza.bernardo.api.ai.core.domain.ChatMessage
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
class PromptGatewayImpl(
    @Autowired private val chatClient: ChatClient,
    @Autowired private val assistantMessage: AssistantMessage
) : PromptGateway {

    override fun create(input: String, oldMessages: List<ChatMessage>): Prompt {
        return Prompt(messages(input, oldMessages), ChatOptionsBuilder.builder().build())
    }

    private fun messages(input: String, oldMessages: List<ChatMessage>): List<Message> {
        if (CollectionUtils.isEmpty(oldMessages)) return listOf(assistantMessage, UserMessage(input))
        return listOf(assistantMessage)
            .plus(toAiMessages(oldMessages))
            .plus(UserMessage(input))
    }

    override fun execute(input: String, oldMessages: List<ChatMessage>): String = chatClient
        .prompt(create(input, oldMessages)).call().chatResponse()
        .result.output.content
}
fun toAiMessages(messages: List<ChatMessage>): List<Message> {
    return messages.map { it.getAiMessage() }
}

