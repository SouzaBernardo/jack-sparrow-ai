package br.com.souza.bernardo.api.ai.core.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "api.ai")
data class PromptProperties(val prompt: String)