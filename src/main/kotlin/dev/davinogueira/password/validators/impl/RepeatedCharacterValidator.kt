package dev.davinogueira.password.validators.impl

import dev.davinogueira.password.validators.Validator

class RepeatedCharacterValidator : Validator {

    override fun isValid(password: String): Boolean {
        val wordCount = password.groupingBy { it }.eachCount().maxOf { it.value }
        return wordCount == 1
    }
}