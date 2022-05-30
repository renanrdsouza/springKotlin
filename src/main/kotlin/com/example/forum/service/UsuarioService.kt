package com.example.forum.service

import com.example.forum.model.Usuario
import com.example.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(
    private val usuarioRepository: UsuarioRepository
) {

    fun getBy(id: Long): Usuario{
        return usuarioRepository.findById(id).get()
    }
}