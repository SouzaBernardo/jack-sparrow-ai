package br.com.souza.bernardo.api.ai.core.request

import jakarta.validation.constraints.NotBlank


data class QuestionRequest(@NotBlank val message: String)
