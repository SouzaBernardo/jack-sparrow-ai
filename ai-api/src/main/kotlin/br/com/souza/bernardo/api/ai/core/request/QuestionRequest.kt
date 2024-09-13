package br.com.souza.bernardo.api.ai.core.request

import jakarta.validation.constraints.NotBlank
import java.util.*


data class QuestionRequest(@NotBlank val message: String, @NotBlank val userId: UUID)
