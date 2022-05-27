package com.example.forum.controller

import com.example.forum.dto.NovoTopicoForm
import com.example.forum.dto.TopicoView
import com.example.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun getAll() : List<TopicoView>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun getBy(@PathVariable id: Long) : TopicoView{
        return service.listarPorId(id)
    }

    @PostMapping
    fun insert(@RequestBody @Valid dto: NovoTopicoForm) {
        service.cadastrar(dto)
    }
}