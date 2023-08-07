package br.com.alura.alura.mock

import br.com.alura.alura.model.Curso
import br.com.alura.alura.model.Topico
import br.com.alura.alura.model.Usuario

object DataMock {
    var topico: MutableList<Topico> = ArrayList()
    //retorna todos os dados
    fun mockTopico(): List<Topico> {
        return geradorDeId(5)
    }

    fun geradorDeId(id: Long): List<Topico> {
        for (i in 0..id) {
            topico.add(
                Topico(
                    id = i,
                    titulo = "Duvidas Kotlin",
                    mensagem = "Nao consigo usar o postman",
                    curso = Curso(
                        id = i,
                        nome = "Kotlin",
                        categoria = "Programacao"
                    ),
                    autor = Usuario(
                        id = i,
                        nome = "Rodrigo",
                        email = "rodrigo.r.guilherme@oulook.com"
                    )
                )
            )
        }
        return topico
    }
    //buscar pelo id
    fun mockSelectTopico(id: Long): Topico {
        return topico.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }
}