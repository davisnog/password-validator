package dev.davinogueira.password.validators.impl

import dev.davinogueira.password.validators.Validator
import java.util.regex.Pattern

class UppercaseValidator : Validator {
    companion object {
        val partner = Pattern.compile("[A-Z]").toRegex()
    }
    override fun isValid(password: String): Boolean {
        return password.contains(partner)
    }
}