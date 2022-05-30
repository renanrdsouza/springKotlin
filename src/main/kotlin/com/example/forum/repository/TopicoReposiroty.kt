package com.example.forum.repository

import com.example.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoReposiroty : JpaRepository<Topico, Long> {
}