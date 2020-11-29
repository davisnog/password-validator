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

    @Test
    fun `test with string empty`(){
        assertFalse(LengthValidator().isValid(" "))
    }

    @Test
    fun `test with white spaces`(){
        assertFalse(LengthValidator().isValid(" 1 2 3 4 5"))
        assertFalse(LengthValidator().isValid(" 1 2 3 4  "))
        assertFalse(LengthValidator().isValid("123456789 "))
    }
}