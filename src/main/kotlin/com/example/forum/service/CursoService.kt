package com.example.forum.service

import com.example.forum.model.Curso
import com.example.forum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Predicate

@Service
class CursoService(
    private val cursoRepository: CursoRepository
) {

    fun getBy(id: Long): Curso {
        return cursoRepository.findById(id).get()
    }
}
