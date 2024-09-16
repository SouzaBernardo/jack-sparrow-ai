package br.com.souza.bernardo.api.ai.core.gateway

import br.com.souza.bernardo.api.ai.core.usecase.CreatePrompt
import br.com.souza.bernardo.api.ai.core.usecase.ExecutePrompt

interface PromptGateway: CreatePrompt, ExecutePrompt