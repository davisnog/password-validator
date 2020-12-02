package dev.davinogueira.server.validators.impl

import dev.davinogueira.server.validators.Validator

class RepeatedCharacterValidator : Validator {

    override fun isValid(password: String): Boolean {
        val wordCount = password.groupingBy { it }.eachCount().maxOfOrNull { it.value }
        return wordCount != null && wordCount == 1
    }
}