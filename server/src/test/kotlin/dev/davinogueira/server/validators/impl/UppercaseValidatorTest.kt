package dev.davinogueira.server.validators.impl

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse

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