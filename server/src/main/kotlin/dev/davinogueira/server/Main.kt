package dev.davinogueira.server

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
    build()
            .args(*args)
            .packages("dev.davinogueira.server")
            .start()
}