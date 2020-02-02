package com.secure.obfuscated

import kotlin.reflect.full.findAnnotation

class SampleProperty {
    val obfuscated: String
        get() = xorDeobfuscator("Test", "27-16-7-4")

    val obfuscatedKotlin: String
        get() = "27-16-7-4".deobfuscate("Test")

    @Obfuscated(key = "Test")
    val obfuscatedAnnotation: String
            by lazy {
                "27-16-7-4".deobfuscate(obfuscated = SampleProperty::obfuscatedAnnotation.findAnnotation())
            }

}