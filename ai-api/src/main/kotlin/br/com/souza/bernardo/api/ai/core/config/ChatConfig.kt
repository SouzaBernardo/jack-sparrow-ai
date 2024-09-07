package br.com.souza.bernardo.api.ai.core.config

import br.com.souza.bernardo.api.ai.core.properties.PromptProperties
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.messages.AssistantMessage
import org.springframework.ai.chat.prompt.AssistantPromptTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ChatConfig(
    @Autowired
    private val promptProperties: PromptProperties
) {
    @Bean("AssistantMessage")
    fun assistantMessage(): AssistantMessage = AssistantPromptTemplate(promptProperties.prompt).createMessage() as AssistantMessage

    @Bean("ChatClient")
    fun chatClient(chatClient: ChatClient.Builder): ChatClient = chatClient.build()
}