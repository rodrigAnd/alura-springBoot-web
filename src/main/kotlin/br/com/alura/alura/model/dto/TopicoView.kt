package br.com.alura.alura.model.dto

import br.com.alura.alura.model.StatusTopico
import java.time.LocalDateTime

data class TopicoView(
    val id: Long? = null,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
)
