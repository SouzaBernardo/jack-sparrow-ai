package br.com.souza.bernardo.api.ai.application.converter

interface BaseConverter <ENTITY, RESPONSE> {
    fun toResponse(entity: ENTITY): RESPONSE
    fun toEntity(response: RESPONSE): ENTITY
}