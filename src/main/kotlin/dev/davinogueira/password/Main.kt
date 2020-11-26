package dev.davinogueira.password
import dev.davinogueira.password.validators.impl.LengthValidator

fun main(args: Array<String>) {
    println(LengthValidator().isValid("23423"))
}