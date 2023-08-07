package br.com.alura.alura.model.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicoForm(
    @field:NotEmpty
    val titulo: String,
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val mensagem: String,
    @field:NotNull
    val idCurso: Long,
    @field:NotNull
    val idAutor: Long
)
