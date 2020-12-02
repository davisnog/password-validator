package dev.davinogueira.server.validators.impl

import dev.davinogueira.server.validators.Validator
import java.util.regex.Pattern

class UppercaseValidator : Validator {
    companion object {
        private val partner = Pattern.compile("[A-Z]").toRegex()
    }

    override fun isValid(password: String): Boolean {
        return password.contains(partner)
    }
}