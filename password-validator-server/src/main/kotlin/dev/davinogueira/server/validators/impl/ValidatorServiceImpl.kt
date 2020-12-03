package dev.davinogueira.server.validators.impl

import dev.davinogueira.server.validators.Password
import dev.davinogueira.server.validators.ValidatorService
import io.micronaut.context.annotation.Prototype

@Prototype
class ValidatorServiceImpl : ValidatorService {

    fun password() : Password {
        val validators = arrayOf(DigitValidatorStrategy(),
            LengthValidatorStrategy(),
            LowercaseValidatorStrategy(),
            RepeatedCharacterValidatorStrategy(),
            SpecialCharacterValidatorStrategy(),
            UppercaseValidatorStrategy(),
            WhitespaceCharacterValidatorStrategy())

        return Password(validators)
    }

    override fun isValid(password: String): Boolean {
        return password().isValid(password)
    }
}