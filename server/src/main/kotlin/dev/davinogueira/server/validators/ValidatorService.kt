package dev.davinogueira.server.validators

interface ValidatorService {
    fun isValid(password: String) : Boolean
}