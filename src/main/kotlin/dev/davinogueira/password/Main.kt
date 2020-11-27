package dev.davinogueira.password

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
    build()
            .args(*args)
            .packages("dev.davinogueira.password")
            .start()
}