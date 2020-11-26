package dev.davinogueira.password.validators

import dev.davinogueira.password.validators.impl.*

class ValidatorsBuilder {

    fun password() : Password {
        return Password()
            .addValidator(DigitValidator())
            .addValidator(LengthValidator())
            .addValidator(LowercaseValidator())
            .addValidator(RepeatedCharacterValidator())
            .addValidator(SpecialCharacterValidator())
            .addValidator(UppercaseValidator())

    }

}