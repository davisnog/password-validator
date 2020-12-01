package dev.davinogueira.server.validators.impl

import dev.davinogueira.server.validators.Validator
import java.util.regex.Pattern

class DigitValidator : Validator {
    companion object {
        val partner = Pattern.compile("\\D").toRegex()
    }
    override fun isValid(password: String): Boolean {
        val digits = password.replace(partner, "")
        return digits.isNotEmpty()
    }
}