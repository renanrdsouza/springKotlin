package com.example.forum.service

import com.example.forum.dto.NovoTopicoForm
import com.example.forum.dto.TopicoView
import com.example.forum.mapper.TopicoFormMapper
import com.example.forum.mapper.TopicoViewMapper
import com.example.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val cursosService: CursoService,
    private val usuarioService: UsuarioService,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map { topico ->
            topicoViewMapper.map(topico)
        }.collect(Collectors.toList())
    }

    fun listarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { topico ->
            topico.id == id
        }.findFirst().get()

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm) {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }
}