package dev.davinogueira.server.validators.impl

import dev.davinogueira.server.validators.ValidatorStrategy
import java.util.regex.Pattern

class DigitValidatorStrategy : ValidatorStrategy {
    companion object {
        val partner = Pattern.compile("\\D").toRegex()
    }
    override fun isValid(password: String): Boolean {
        val digits = password.replace(partner, "")
        return digits.isNotEmpty()
    }
}