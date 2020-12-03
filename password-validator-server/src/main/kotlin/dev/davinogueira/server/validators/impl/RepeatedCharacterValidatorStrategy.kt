package dev.davinogueira.server.validators.impl

import dev.davinogueira.server.validators.ValidatorStrategy

class RepeatedCharacterValidatorStrategy : ValidatorStrategy {

    override fun isValid(password: String): Boolean {
        val wordCount = password.groupingBy { it }.eachCount().maxOfOrNull { it.value }
        return wordCount != null && wordCount == 1
    }
}