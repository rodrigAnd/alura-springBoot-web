package br.com.alura.alura.service

import br.com.alura.alura.mapper.TopicoFormMapper
import br.com.alura.alura.mapper.TopicoViewMapper
import br.com.alura.alura.model.*
import br.com.alura.alura.model.dto.AtualizacaoTopicoForm
import br.com.alura.alura.model.dto.TopicoForm
import br.com.alura.alura.model.dto.TopicoView
import jakarta.validation.Valid
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import java.time.LocalDateTime
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicoService: List<Topico> = ArrayList(),
    private var topicoViewMapper: TopicoViewMapper,
    private var topicoFormMapper: TopicoFormMapper
) {


    fun listar(): List<TopicoView> {
        return topicoService.stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topicoView = topicoService.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return topicoViewMapper.map(topicoView)
    }

    fun cadastrarTopico(form: TopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topico.id = topicoService.size.toLong() + 1
        topicoService = topicoService.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicoService.stream().filter { t ->
            t.id == form.id
        }.findFirst().get()
        val novoTopicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            curso = topico.curso,
            autor = topico.autor,
            dataCriacao = topico.dataCriacao,
            status = topico.status,
            resposta = topico.resposta
        )
        topicoService = topicoService.minus(topico).plus(novoTopicoAtualizado)
        return topicoViewMapper.map(novoTopicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicoService.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        topicoService = topicoService.minus(topico)
    }
}