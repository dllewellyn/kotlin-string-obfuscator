package com.secure.obfuscated

class SampleProperty {
    val obfuscated: String
        get() = xorDeobfuscator("Test", "27-16-7-4")

}