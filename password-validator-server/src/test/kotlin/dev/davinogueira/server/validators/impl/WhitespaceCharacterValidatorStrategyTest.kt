package dev.davinogueira.server.validators.impl

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse


class WhitespaceCharacterValidatorStrategyTest {

    @Test
    fun `test with value valid`() {
        assertTrue(WhitespaceCharacterValidatorStrategy().isValid("1223234"))
    }

    @Test
    fun `test with value invalid`() {
        assertFalse(WhitespaceCharacterValidatorStrategy().isValid(" "))
        assertFalse(WhitespaceCharacterValidatorStrategy().isValid(" 1 2 3 4 5"))
        assertFalse(WhitespaceCharacterValidatorStrategy().isValid(" 1 2 3 4  "))
        assertFalse(WhitespaceCharacterValidatorStrategy().isValid("123456789 "))
    }
}