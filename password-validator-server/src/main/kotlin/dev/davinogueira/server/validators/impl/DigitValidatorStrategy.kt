package dev.davinogueira.server.validators.impl

import dev.davinogueira.server.validators.ValidatorStrategy
import java.util.regex.Pattern

class DigitValidatorStrategy : ValidatorStrategy {
    companion object {
        private val numbers = Pattern.compile("\\d").toRegex()
    }
    override fun isValid(password: String): Boolean {
        return password.contains(numbers)
    }
}