package br.com.alura.alura.mapper

import br.com.alura.alura.model.Topico
import br.com.alura.alura.model.dto.TopicoView
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper : Mapper<Topico, TopicoView> {
    override fun map(t: Topico): TopicoView {
        return TopicoView(
            id = t.id,
            mensagem = t.mensagem,
            titulo = t.titulo,
            dataCriacao = t.dataCriacao,
            status = t.status
        )
    }
}