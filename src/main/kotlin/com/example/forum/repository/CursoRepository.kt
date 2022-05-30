package com.example.forum.repository

import com.example.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<Curso, Long> {
}