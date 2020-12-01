package dev.davinogueira.server.validators

interface Validator {
    fun isValid(password :String) : Boolean
}