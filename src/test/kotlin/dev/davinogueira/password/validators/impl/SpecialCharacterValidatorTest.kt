package dev.davinogueira.password.validators.impl

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SpecialCharacterValidatorTest {

    @Test
    fun `test password with special character ! valid`(){
        assertTrue(SpecialCharacterValidator().isValid("asd34!fAh"))
    }

    @Test
    fun `test password with special character @ valid`(){
        assertTrue(SpecialCharacterValidator().isValid("asd34@fAh"))
    }

    @Test
    fun `test password with special character # valid`(){
        assertTrue(SpecialCharacterValidator().isValid("asd34#fAh"))
    }

    @Test
    fun `test password with special character $ valid`(){
        assertTrue(SpecialCharacterValidator().isValid("asd34\$fAh"))
    }

    @Test
    fun `test password with special character percent valid`(){
        assertTrue(SpecialCharacterValidator().isValid("asd34%fAh"))
    }

    @Test
    fun `test password with special character ^ valid`(){
        assertTrue(SpecialCharacterValidator().isValid("asd34^fAh"))
    }

    @Test
    fun `test password with special character & valid`(){
        assertTrue(SpecialCharacterValidator().isValid("asd34&fAh"))
    }

    @Test
    fun `test password with special character asterisk valid`(){
        assertTrue(SpecialCharacterValidator().isValid("asd34*fAh"))
    }

    @Test
    fun `test password with special character ( valid`(){
        assertTrue(SpecialCharacterValidator().isValid("asd34(fAh"))
    }

    @Test
    fun `test password with special character ) valid`(){
        assertTrue(SpecialCharacterValidator().isValid("asd34)fAh"))
    }

    @Test
    fun `test password with special character - valid`(){
        assertTrue(SpecialCharacterValidator().isValid("asd34-fAh"))
    }

    @Test
    fun `test password with special character + valid`(){
        assertTrue(SpecialCharacterValidator().isValid("asd34+fAh"))
    }

    @Test
    fun `test password with special character invalid`(){
        assertFalse(SpecialCharacterValidator().isValid("asd34;fAh.?="))
    }

    @Test
    fun `test password no special character`(){
        assertFalse(SpecialCharacterValidator().isValid("asd34pOqA"))
    }


}