package dev.davinogueira.server.validators.impl

import dev.davinogueira.server.validators.ValidatorStrategy
import java.util.regex.Pattern

class WhitespaceCharacterValidatorStrategy : ValidatorStrategy {
    companion object {
        private val whitespace = Pattern.compile("\\s").toRegex()
    }

    override fun isValid(password: String): Boolean {
        return !password.contains(whitespace)
    }
}