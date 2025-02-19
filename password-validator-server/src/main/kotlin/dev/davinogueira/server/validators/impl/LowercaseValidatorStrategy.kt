package dev.davinogueira.server.validators.impl

import dev.davinogueira.server.validators.ValidatorStrategy
import java.util.regex.Pattern

class LowercaseValidatorStrategy : ValidatorStrategy {
    companion object {
        private val lowercase = Pattern.compile("[a-z]").toRegex()
    }
    override fun isValid(password: String): Boolean {
        return password.contains(lowercase)
    }
}