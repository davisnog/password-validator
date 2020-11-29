package dev.davinogueira.password.validators.impl

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidatorServiceImplTest {

    @Test
    fun `test password is invalid`(){
        val pswd = ValidatorServiceImpl().password()

        assertFalse(pswd.isValid(""))
        assertFalse(pswd.isValid("aa"))
        assertFalse(pswd.isValid("ab"))
        assertFalse(pswd.isValid("AAAbbbCc"))
        assertFalse(pswd.isValid("AbTp9!foo"))
        assertFalse(pswd.isValid("AbTp9!foA"))
        assertFalse(pswd.isValid("AbTp9 fok"))
        assertTrue(pswd.isValid("AbTp9!fok "))
    }

    @Test
    fun `test password is valid`() {
        val pswd = ValidatorServiceImpl().password()

        assertTrue(pswd.isValid("AbTp9!fok"))
    }
}