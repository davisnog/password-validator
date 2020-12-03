package dev.davinogueira.server.validators

interface ValidatorStrategy {
    fun isValid(password :String) : Boolean
}