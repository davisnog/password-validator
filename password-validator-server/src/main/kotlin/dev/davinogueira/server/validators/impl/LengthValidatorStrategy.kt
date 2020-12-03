package dev.davinogueira.server.validators.impl

import dev.davinogueira.server.validators.ValidatorStrategy

class LengthValidatorStrategy : ValidatorStrategy {
    override fun isValid(password: String): Boolean {
        return password.length >= 9
    }
}