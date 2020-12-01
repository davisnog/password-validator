package dev.davinogueira.server.validators.impl

import dev.davinogueira.server.validators.Password
import dev.davinogueira.server.validators.ValidatorService
import io.micronaut.context.annotation.Prototype

@Prototype
class ValidatorServiceImpl : ValidatorService {

    fun password() : Password {
        return Password()
            .addValidator(DigitValidator())
            .addValidator(LengthValidator())
            .addValidator(LowercaseValidator())
            .addValidator(RepeatedCharacterValidator())
            .addValidator(SpecialCharacterValidator())
            .addValidator(UppercaseValidator())
            .addValidator(WhitespaceCharacterValidator())

    }

    override fun isValid(password: String): Boolean {
        return password().isValid(password)
    }

}