package dev.davinogueira.password.validators

interface ValidatorService {
    fun isValid(password: String) : Boolean
}