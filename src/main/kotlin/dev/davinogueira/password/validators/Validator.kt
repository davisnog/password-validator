package dev.davinogueira.password.validators

interface Validator {
    fun isValid(password :String) : Boolean
}