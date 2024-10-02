package br.com.souza.bernardo.api.ai.core.gateway

import br.com.souza.bernardo.api.ai.core.usecase.*

interface CrudChatGateway: FindChatByUserId, SaveChat
interface PromptGateway: CreatePrompt, ExecutePrompt
interface QuestionGateway: DoQuestion