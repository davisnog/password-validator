package dev.davinogueira.password.validators.impl

import dev.davinogueira.password.validators.Validator

class LengthValidator : Validator {
    override fun isValid(password: String): Boolean {
        return password.length >= 9
    }

}