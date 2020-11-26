package dev.davinogueira.password.validators.impl

import dev.davinogueira.password.validators.Validator
import java.util.regex.Pattern

class LengthValidator : Validator {
    companion object {
        private val partner = Pattern.compile("\\s").toRegex()
    }

    override fun isValid(password: String): Boolean {
        return password.replace(partner, "").length >= 9
    }

}