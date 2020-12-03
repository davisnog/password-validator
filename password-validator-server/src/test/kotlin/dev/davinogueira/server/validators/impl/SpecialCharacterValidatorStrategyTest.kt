package dev.davinogueira.server.validators.impl

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse

class SpecialCharacterValidatorStrategyTest {

    @Test
    fun `test password with special character ! valid`(){
        assertTrue(SpecialCharacterValidatorStrategy().isValid("asd34!fAh"))
    }

    @Test
    fun `test password with special character @ valid`(){
        assertTrue(SpecialCharacterValidatorStrategy().isValid("asd34@fAh"))
    }

    @Test
    fun `test password with special character # valid`(){
        assertTrue(SpecialCharacterValidatorStrategy().isValid("asd34#fAh"))
    }

    @Test
    fun `test password with special character $ valid`(){
        assertTrue(SpecialCharacterValidatorStrategy().isValid("asd34\$fAh"))
    }

    @Test
    fun `test password with special character percent valid`(){
        assertTrue(SpecialCharacterValidatorStrategy().isValid("asd34%fAh"))
    }

    @Test
    fun `test password with special character ^ valid`(){
        assertTrue(SpecialCharacterValidatorStrategy().isValid("asd34^fAh"))
    }

    @Test
    fun `test password with special character & valid`(){
        assertTrue(SpecialCharacterValidatorStrategy().isValid("asd34&fAh"))
    }

    @Test
    fun `test password wialseth special character asterisk valid`(){
        assertTrue(SpecialCharacterValidatorStrategy().isValid("asd34*fAh"))
    }

    @Test
    fun `test password with special character ( valid`(){
        assertTrue(SpecialCharacterValidatorStrategy().isValid("asd34(fAh"))
    }

    @Test
    fun `test password with special character ) valid`(){
        assertTrue(SpecialCharacterValidatorStrategy().isValid("asd34)fAh"))
    }

    @Test
    fun `test password with special character - valid`(){
        assertTrue(SpecialCharacterValidatorStrategy().isValid("asd34-fAh"))
    }

    @Test
    fun `test password with special character + valid`(){
        assertTrue(SpecialCharacterValidatorStrategy().isValid("asd34+fAh"))
    }

    @Test
    fun `test password with special character invalid`(){
        assertFalse(SpecialCharacterValidatorStrategy().isValid("asd34;fAh.?="))
    }

    @Test
    fun `test password no special character`(){
        assertFalse(SpecialCharacterValidatorStrategy().isValid("asd34pOqA"))
    }

    @Test
    fun `test password has more on special character`(){
        assertTrue(SpecialCharacterValidatorStrategy().isValid("asd34pOqA%#"))
    }


}