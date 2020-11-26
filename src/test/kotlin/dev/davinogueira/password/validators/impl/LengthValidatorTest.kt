package dev.davinogueira.password.validators.impl

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class LengthValidatorTest {

    @Test
    fun `test with length is valid`(){
        assertTrue(LengthValidator().isValid("123456789"))
    }

    @Test
    fun `test with length is invalid`(){
        assertFalse(LengthValidator().isValid("12345678"))
    }
}