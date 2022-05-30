package com.example.forum.controller

import com.example.forum.dto.AtualizacaoForm
import com.example.forum.dto.NovoTopicoForm
import com.example.forum.dto.TopicoView
import com.example.forum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun getAll(): List<TopicoView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun getBy(@PathVariable id: Long): TopicoView {
        return service.listarPorId(id)
    }

    @PostMapping
    fun insert(@RequestBody @Valid form: NovoTopicoForm,
               uriBuilder: UriComponentsBuilder
               ): ResponseEntity<TopicoView> {
        val topicoView = service.cadastrar(form)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    fun update(@RequestBody @Valid form: AtualizacaoForm): ResponseEntity<TopicoView> {
        val topicoAtualizado = service.atualizar(form)
        return ResponseEntity.ok().body(topicoAtualizado)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.deletar(id)
    }
}