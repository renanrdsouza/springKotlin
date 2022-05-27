package com.example.forum.service

import com.example.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(
    var autores: List<Usuario>
) {

    init {
        val autor = Usuario(
            id = 1,
            nome = "Renan",
            email = "renan@email.com"
        )
        autores = Arrays.asList(autor)
    }

    fun getBy(id: Long): Usuario{
        return autores.stream().filter { autor ->
            autor.id == id
        }.findFirst().get()
    }
}