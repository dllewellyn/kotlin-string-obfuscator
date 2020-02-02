package com.secure.obfuscated

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class XorObfuscatorKtTest {

    @Test(expected = WrongLengthException::class)
    fun `test that the obfuscator throws an exception when length doesnt match keys`() {
        xorObfuscator("A", "BB")
    }

    @Test
    fun `test that if we obfuscated with a key it will unobfuscate to the same thing`() {
        val input = "Abcdef"
        val key = "Output"

        val result =  xorObfuscator(key, input)
        assertNotEquals(input, result)
        assertEquals(input, xorDeobfuscator(key, result))
    }

    @Test
    fun `test that if we obfuscated with a key it will unobfuscate to the a different thing with the wrong key`() {
        val input = "Abcdef"
        val key = "Output"

        val result =  xorObfuscator(input, key)
        assertNotEquals(input, result)
        assertNotEquals(input, xorDeobfuscator(result, "27-16-7-4"))
    }

    @Test
    fun `test that we can get the annotated property`() {
        assertEquals(SampleProperty()
            .obfuscated, "Outp")
    }

    @Test
    fun `test that we can use the kotlin extension function to decrypt`() {
        assertEquals(SampleProperty().obfuscatedKotlin, "Outp")
    }

    @Test
    fun `test that we can use the kotlin extension function and annotation to decrypt`() {
        assertEquals(SampleProperty().obfuscatedAnnotation, "Outp")
    }
}