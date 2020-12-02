package dev.davinogueira.server.validators.impl

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse

class LowercaseValidatorTest {

    @Test
    fun `test with password has more one lowercase character`() {
        assertTrue(LowercaseValidator().isValid("a2323b23#"))
    }

    @Test
    fun `test with password has one lowercase character`() {
        assertTrue(LowercaseValidator().isValid("a2323%23#"))
    }

    @Test
    fun `test with password no has lowercase character`() {
        assertFalse(LowercaseValidator().isValid("BASDF%23#"))
    }
}