package dev.davinogueira.server.validators.impl

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse

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
    fun `test password wialseth special character asterisk valid`(){
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

    @Test
    fun `test password has more on special character`(){
        assertTrue(SpecialCharacterValidator().isValid("asd34pOqA%#"))
    }


}