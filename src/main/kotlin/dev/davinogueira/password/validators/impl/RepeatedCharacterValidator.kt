package dev.davinogueira.password.validators.impl

import dev.davinogueira.password.validators.Validator

class RepeatedCharacterValidator : Validator {

    override fun isValid(password: String): Boolean {
        val wordCount = password.groupingBy { it }.eachCount().maxOfOrNull { it.value }
        return wordCount != null && wordCount == 1
    }
}