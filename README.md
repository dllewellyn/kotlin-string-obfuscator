# kotlin-string-obfuscator
Simple kotlin string obfuscator

![CI](https://github.com/dllewellyn/kotlin-string-obfuscator/workflows/CI/badge.svg)

Usage

```
class SampleProperty {
    val obfuscated: String
        get() = xorDeobfuscator("Test", "27-16-7-4")

    val obfuscatedKotlin: String
        get() = "27-16-7-4".deobfuscate("Test")

}
```
