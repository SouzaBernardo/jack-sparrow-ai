package br.com.souza.bernardo.api.ai.core.usecase

interface SaveChat<ENTITY, RESPONSE> {
    fun save(entity: ENTITY): RESPONSE
}