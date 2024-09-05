package br.com.souza.bernardo.api.ia.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "api.ai")
data class PromptProperties(
    val prompt: String,
    val model: String,
    val temperature: Float,
)