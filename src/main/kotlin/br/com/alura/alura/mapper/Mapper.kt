package br.com.alura.alura.mapper

interface Mapper<T, U> {
        fun map(t: T): U
}
