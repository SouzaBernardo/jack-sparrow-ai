package br.com.souza.bernardo.api.ai.dataprovider.impl

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ChatServiceTest(@Autowired private val service: ChatService) {

    @Test
    fun test() {
        // TODO: Mongo testcontainer
        println()
    }

}