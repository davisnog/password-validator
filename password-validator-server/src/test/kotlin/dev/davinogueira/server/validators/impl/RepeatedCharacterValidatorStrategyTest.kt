package dev.davinogueira.server.validators.impl

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse

class RepeatedCharacterValidatorStrategyTest {

    @Test
    fun `test with password no repeated characters`() {
        assertTrue(RepeatedCharacterValidatorStrategy().isValid("123asd456fgh%"))
    }

    @Test
    fun `test with password repeated special character`() {
        assertFalse(RepeatedCharacterValidatorStrategy().isValid("123asd456fgh%%"))
    }

    @Test
    fun `test with password repeated character`() {
        assertFalse(RepeatedCharacterValidatorStrategy().isValid("123asd456fghasd"))
    }

    @Test
    fun `test with password repeated digits`() {
        assertFalse(RepeatedCharacterValidatorStrategy().isValid("123asd456fgh456"))
    }

    @Test
    fun `test with password empty`() {
        assertFalse(RepeatedCharacterValidatorStrategy().isValid(""))
    }
}