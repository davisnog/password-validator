package dev.davinogueira.password.validators.impl

import dev.davinogueira.password.validators.Validator
import java.util.regex.Pattern

class SpecialCharacterValidator : Validator {
    companion object {
        val partner = Pattern.compile("[!@#\$%^&*()\\-+]").toRegex()
    }

    override fun isValid(password: String): Boolean {
        return password.contains(partner)
    }
}