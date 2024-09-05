package br.com.souza.bernardo.api.ai.service

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
) {
    private fun create(message: String): Prompt = Prompt(listOf(assistantMessage, UserMessage(message)), ChatOptionsBuilder.builder().build())

    private fun execute(prompt: Prompt): String = chatClient
        .build()
        .prompt(prompt).call().chatResponse()
        .result.output.content

    fun question(message: String): String = execute(create(message))
}
