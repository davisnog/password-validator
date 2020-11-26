package dev.davinogueira.password.validators.impl

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RepeatedCharacterValidatorTest {

    @Test
    fun `test with password no repeated characters`() {
        assertTrue(RepeatedCharacterValidator().isValid("123asd456fgh%"))
    }

    @Test
    fun `test with password repeated special character`() {
        assertFalse(RepeatedCharacterValidator().isValid("123asd456fgh%%"))
    }

    @Test
    fun `test with password repeated character`() {
        assertFalse(RepeatedCharacterValidator().isValid("123asd456fghasd"))
    }

    @Test
    fun `test with password repeated digits`() {
        assertFalse(RepeatedCharacterValidator().isValid("123asd456fgh456"))
    }

    @Test
    fun `test with password empty`() {
        assertFalse(RepeatedCharacterValidator().isValid(""))
    }
}