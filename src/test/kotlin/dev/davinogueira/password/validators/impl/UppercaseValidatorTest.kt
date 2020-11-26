package dev.davinogueira.password.validators.impl

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class UppercaseValidatorTest {

    @Test
    fun `test password with uppercase character`(){
        assertTrue(UppercaseValidator().isValid("dsaf989#A"))
    }

    @Test
    fun `test password with more one uppercase character`(){
        assertTrue(UppercaseValidator().isValid("dsaf989#ABBDD"))
    }

    @Test
    fun `test password no uppercase character`(){
        assertFalse(UppercaseValidator().isValid("dsaf989#"))
    }
}