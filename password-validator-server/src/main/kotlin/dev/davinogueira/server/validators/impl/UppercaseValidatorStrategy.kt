package dev.davinogueira.server.validators.impl

import dev.davinogueira.server.validators.ValidatorStrategy
import java.util.regex.Pattern

class UppercaseValidatorStrategy : ValidatorStrategy {
    companion object {
        private val uppercase = Pattern.compile("[A-Z]").toRegex()
    }

    override fun isValid(password: String): Boolean {
        return password.contains(uppercase)
    }
}