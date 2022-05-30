package com.example.forum.service

import com.example.forum.dto.AtualizacaoForm
import com.example.forum.dto.NovoTopicoForm
import com.example.forum.dto.TopicoView
import com.example.forum.exception.NotFoundException
import com.example.forum.mapper.TopicoFormMapper
import com.example.forum.mapper.TopicoViewMapper
import com.example.forum.model.Topico
import com.example.forum.repository.TopicoReposiroty
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.net.URI
import java.util.stream.Collectors

@Service
class TopicoService(
    private val topicoReposiroty: TopicoReposiroty,
    private val cursosService: CursoService,
    private val usuarioService: UsuarioService,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado"
) {

    fun listar(): List<TopicoView> {
        return topicoReposiroty.findAll().stream().map { topico ->
            topicoViewMapper.map(topico)
        }.collect(Collectors.toList())
    }

    fun listarPorId(id: Long): TopicoView {
        val topico = topicoReposiroty.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)

        topicoReposiroty.save(topico)

        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoForm): TopicoView {
        val topico = topicoReposiroty.findById(form.id)
            .orElseThrow{NotFoundException(notFoundMessage)}

        topico.titulo = form.titulo
        topico.mensagem = form.mensagem

        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        topicoReposiroty.deleteById(id)
    }
}