package br.com.souza.bernardo.api.ai.application.converter

interface BaseConverter <ENTITY, RESPONSE> {
    fun convert(entity: ENTITY): RESPONSE
    fun convert(response: RESPONSE): ENTITY
}