package dev.davinogueira.server.validators.impl

import dev.davinogueira.server.validators.Validator

class LengthValidator : Validator {
    override fun isValid(password: String): Boolean {
        return password.length >= 9
    }
}