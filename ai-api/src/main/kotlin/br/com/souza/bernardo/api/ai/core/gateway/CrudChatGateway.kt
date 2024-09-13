package br.com.souza.bernardo.api.ai.core.gateway

import br.com.souza.bernardo.api.ai.core.usecase.FindChatByUserId
import br.com.souza.bernardo.api.ai.core.usecase.SaveChat
import org.springframework.stereotype.Service

@Service
interface CrudChatGateway: FindChatByUserId, SaveChat {
}