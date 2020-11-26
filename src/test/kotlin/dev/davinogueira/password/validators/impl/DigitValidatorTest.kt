package dev.davinogueira.password.validators.impl

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DigitValidatorTest {

    @Test
    fun `test password has more one digit`(){
        assertTrue(DigitValidator().isValid("1asdf234"))
    }

    @Test
    fun `test password has digit`(){
        assertTrue(DigitValidator().isValid("1aaaaaadddd"))
    }

    @Test
    fun `test password no has digit`(){
        assertFalse(DigitValidator().isValid("baaaaaadddd"))
    }
}