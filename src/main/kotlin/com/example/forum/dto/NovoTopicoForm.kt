package com.example.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class NovoTopicoForm(

    @NotEmpty
    val titulo: String,

    @NotEmpty
    val mensagem: String,

    @NotNull
    val idCurso: Long,

    @NotNull
    val idAutor: Long
)
