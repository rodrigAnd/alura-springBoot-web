package br.com.alura.alura.exception

import java.lang.RuntimeException

class NotFoundException(message: String?): RuntimeException(message) {
}