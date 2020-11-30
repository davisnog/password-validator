package dev.davinogueira.password.validators.impl

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse


class LengthValidatorTest {

    @Test
    fun `test with length is valid`(){
        assertTrue(LengthValidator().isValid("123456789"))
    }

    @Test
    fun `test with length is invalid`(){
        assertFalse(LengthValidator().isValid("12345678"))
        assertFalse(LengthValidator().isValid("123"))
        assertFalse(LengthValidator().isValid(""))
    }
}