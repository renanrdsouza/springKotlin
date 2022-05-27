package com.example.forum.mapper

import com.example.forum.dto.NovoTopicoForm
import com.example.forum.model.Topico
import com.example.forum.service.CursoService
import com.example.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
   private val cursosService: CursoService,
   private val usuarioService: UsuarioService
): Mapper<NovoTopicoForm, Topico> {

    override fun map(topico: NovoTopicoForm): Topico {
        return Topico(
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            curso = cursosService.getBy(topico.idCurso),
            autor = usuarioService.getBy(topico.idAutor)
        )
    }

}
