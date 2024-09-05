package br.com.souza.bernardo.api.ia.config

import br.com.souza.bernardo.api.ia.properties.PromptProperties
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.messages.AssistantMessage
import org.springframework.ai.chat.prompt.AssistantPromptTemplate
import org.springframework.ai.chat.prompt.ChatOptions
import org.springframework.ai.chat.prompt.ChatOptionsBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ChatConfig(
    @Autowired
    private val promptProperties: PromptProperties
) {
    @Bean("AssistantMessage")
    fun systemMessage(): AssistantMessage =
        AssistantPromptTemplate(promptProperties.prompt).createMessage() as AssistantMessage

    @Bean("ChatClient")
    fun chatClient(chatClient: ChatClient.Builder): ChatClient = chatClient.build()

//    @Bean
    fun chatOptions(): ChatOptions = ChatOptionsBuilder.builder()
        .withModel(promptProperties.model)
        .withTemperature(promptProperties.temperature)
        .build()
}