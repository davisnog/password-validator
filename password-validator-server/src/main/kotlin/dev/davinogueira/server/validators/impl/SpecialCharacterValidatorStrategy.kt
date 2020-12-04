package dev.davinogueira.server.validators.impl

import dev.davinogueira.server.validators.ValidatorStrategy
import java.util.regex.Pattern

class SpecialCharacterValidatorStrategy : ValidatorStrategy {
    companion object {
        private val symbolsValid = Pattern.compile("[!@#\$%^&*()\\-+]").toRegex()
    }

    override fun isValid(password: String): Boolean {
        return password.contains(symbolsValid)
    }
}