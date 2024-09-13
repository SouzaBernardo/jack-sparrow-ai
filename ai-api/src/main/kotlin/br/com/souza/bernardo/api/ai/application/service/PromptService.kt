package br.com.souza.bernardo.api.ai.application.service

import br.com.souza.bernardo.api.ai.core.gateway.PromptGateway
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.messages.AssistantMessage
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

    override fun create(input: String): Prompt =
        Prompt(listOf(assistantMessage, UserMessage(input)), ChatOptionsBuilder.builder().build())

    override fun execute(input: String): String = chatClient
        .build()
        .prompt(create(input)).call().chatResponse()
        .result.output.content
}
