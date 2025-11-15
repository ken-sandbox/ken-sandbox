package com.example.androidappsample

import org.junit.Assert.*
import org.junit.Test

class GreetingUtilTest {

    @Test
    fun greet_withValidName_returnsGreetingWithName() {
        val result = GreetingUtil.greet("Alice")
        assertEquals("Hello, Alice!", result)
    }

    @Test
    fun greet_withEmptyName_returnsDefaultGreeting() {
        val result = GreetingUtil.greet("")
        assertEquals("Hello, World!", result)
    }

    @Test
    fun greet_withBlankName_returnsDefaultGreeting() {
        val result = GreetingUtil.greet("   ")
        assertEquals("Hello, World!", result)
    }

    @Test
    fun isValidName_withValidName_returnsTrue() {
        assertTrue(GreetingUtil.isValidName("Bob"))
    }

    @Test
    fun isValidName_withEmptyName_returnsFalse() {
        assertFalse(GreetingUtil.isValidName(""))
    }

    @Test
    fun isValidName_withBlankName_returnsFalse() {
        assertFalse(GreetingUtil.isValidName("   "))
    }

    @Test
    fun countWords_withSimpleMessage_returnsCorrectCount() {
        val message = "Hello, World!"
        val count = GreetingUtil.countWords(message)
        assertEquals(2, count)
    }

    @Test
    fun countWords_withMultipleWords_countsCorrectly() {
        val message = "Hello Alice and Bob"
        val count = GreetingUtil.countWords(message)
        assertEquals(4, count)
    }

    @Test
    fun countWords_withExtraSpaces_handlesCorrectly() {
        val message = "Hello   World  !"
        val count = GreetingUtil.countWords(message)
        assertEquals(3, count)
    }

    @Test
    fun countWords_withEmptyString_returnsZero() {
        val message = ""
        val count = GreetingUtil.countWords(message)
        assertEquals(0, count)
    }
}
