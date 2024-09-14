package br.com.souza.bernardo.api.ai.application.service

import br.com.souza.bernardo.api.ai.core.gateway.PromptGateway
import br.com.souza.bernardo.api.ai.core.request.OldMessages
import br.com.souza.bernardo.api.ai.core.request.getHistory
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.messages.AssistantMessage
import org.springframework.ai.chat.messages.Message
import org.springframework.ai.chat.messages.UserMessage
import org.springframework.ai.chat.prompt.ChatOptionsBuilder
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PromptService(
    @Autowired private val chatClient: ChatClient.Builder,
    @Autowired private val assistantMessage: AssistantMessage
) : PromptGateway {

    override fun create(input: String, oldMessages: OldMessages?): Prompt {
        val messages: List<Message> =
            oldMessages?.getHistory()?.plus(listOf(assistantMessage, UserMessage(input))) ?:
            listOf(assistantMessage, UserMessage(input))

        return Prompt(messages, ChatOptionsBuilder.builder().build())
    }

    override fun execute(input: String, oldMessages: OldMessages?): String = chatClient
        .build()
        .prompt(create(input, oldMessages)).call().chatResponse()
        .result.output.content
}
