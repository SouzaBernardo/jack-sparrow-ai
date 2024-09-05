package br.com.souza.bernardo.api.ia

import br.com.souza.bernardo.api.ia.properties.PromptProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(PromptProperties::class)
@SpringBootApplication
class IaApplication

fun main(args: Array<String>) {
    runApplication<IaApplication>(*args)
}