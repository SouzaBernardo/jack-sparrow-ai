package br.com.souza.bernardo.api.ai.dataprovider.converter

interface BaseConverter <ENTITY, RESPONSE> {
    fun convertFromEntity(entity: ENTITY): RESPONSE
    fun convertToEntity(response: RESPONSE): ENTITY
}