package dev.davinogueira.server.validators.impl

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse


class LengthValidatorStrategyTest {

    @Test
    fun `test with length is valid`(){
        assertTrue(LengthValidatorStrategy().isValid("123456789"))
    }

    @Test
    fun `test with length is invalid`(){
        assertFalse(LengthValidatorStrategy().isValid("12345678"))
        assertFalse(LengthValidatorStrategy().isValid("123"))
        assertFalse(LengthValidatorStrategy().isValid(""))
    }
}