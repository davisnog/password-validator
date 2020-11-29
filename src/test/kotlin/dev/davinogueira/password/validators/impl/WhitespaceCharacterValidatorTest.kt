package dev.davinogueira.password.validators.impl

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class WhitespaceCharacterValidatorTest {

    @Test
    fun `test with value valid`() {
        assertTrue(WhitespaceCharacterValidator().isValid("1223234"))
    }

    @Test
    fun `test with value invalid`() {
        assertFalse(WhitespaceCharacterValidator().isValid(" "))
        assertFalse(WhitespaceCharacterValidator().isValid(" 1 2 3 4 5"))
        assertFalse(WhitespaceCharacterValidator().isValid(" 1 2 3 4  "))
        assertFalse(WhitespaceCharacterValidator().isValid("123456789 "))
    }
}