package dev.davinogueira.server.validators.impl

import dev.davinogueira.server.validators.Validator
import java.util.regex.Pattern

class LowercaseValidator : Validator {
    companion object {
        val partner = Pattern.compile("[a-z]").toRegex()
    }
    override fun isValid(password: String): Boolean {
        return password.contains(partner)
    }
}