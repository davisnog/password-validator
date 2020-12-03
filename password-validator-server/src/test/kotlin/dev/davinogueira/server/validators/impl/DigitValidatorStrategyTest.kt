package dev.davinogueira.server.validators.impl

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse

class DigitValidatorStrategyTest {

    @Test
    fun `test password has more one digit`(){
        assertTrue(DigitValidatorStrategy().isValid("1asdf234"))
    }

    @Test
    fun `test password has digit`(){
        assertTrue(DigitValidatorStrategy().isValid("1aaaaaadddd"))
    }

    @Test
    fun `test password no has digit`(){
        assertFalse(DigitValidatorStrategy().isValid("baaaaaadddd"))
    }
}