package com.example.forum.service

import com.example.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Predicate

@Service
class CursoService(
    var cursos: List<Curso>
) {

    init {
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )

        cursos = Arrays.asList(curso)
    }

    fun getBy(id: Long): Curso {
        return cursos.stream().filter { curso ->
            curso.id == id
        }.findFirst().get()
    }
}
