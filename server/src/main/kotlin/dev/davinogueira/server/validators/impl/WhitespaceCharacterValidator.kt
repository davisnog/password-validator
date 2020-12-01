package dev.davinogueira.server.validators.impl

import dev.davinogueira.server.validators.Validator
import java.util.regex.Pattern

class WhitespaceCharacterValidator : Validator {
    companion object {
        private val whitespacePattern = Pattern.compile("\\s").toRegex()
    }

    override fun isValid(password: String): Boolean {
        return !password.contains(whitespacePattern)
    }
}