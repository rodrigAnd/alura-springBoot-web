package br.com.alura.alura.service

import br.com.alura.alura.model.Curso
import br.com.alura.alura.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class AutorService(
    private var autor: List<Usuario>
) {
    init {
        val autores = Usuario(
            id = 1,
            nome = "Rodrigo",
            email = "rodrigo.r.guilherme@outlook.com"
        )
        autor = Arrays.asList(autores)
    }

    fun buscarPorId(idAutor: Long): Usuario {
        return autor.stream().filter { t ->
            t.id == idAutor
        }.findFirst().get()
    }
}