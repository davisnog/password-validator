package dev.davinogueira.client

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
    build()
            .args(*args)
            .packages("dev.davinogueira.client")
            .start()
}