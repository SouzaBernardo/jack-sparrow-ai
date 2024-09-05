package br.com.souza.bernardo.api.ai

import br.com.souza.bernardo.api.ai.properties.PromptProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(PromptProperties::class)
@SpringBootApplication
class aiApplication

fun main(args: Array<String>) {
    runApplication<aiApplication>(*args)
}