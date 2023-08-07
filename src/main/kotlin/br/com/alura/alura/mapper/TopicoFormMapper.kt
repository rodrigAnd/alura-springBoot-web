package br.com.alura.alura.mapper

import br.com.alura.alura.model.Topico
import br.com.alura.alura.model.dto.TopicoForm
import br.com.alura.alura.service.AutorService
import br.com.alura.alura.service.CursoService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private var autorService: AutorService,
    private var cursoService: CursoService
) : Mapper<TopicoForm, Topico> {
    override fun map(t: TopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = autorService.buscarPorId(t.idAutor)
        )
    }
}