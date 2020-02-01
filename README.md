# kotlin-string-obfuscator
Simple kotlin string obfuscator

![CI](https://github.com/dllewellyn/kotlin-string-obfuscator/workflows/CI/badge.svg)

Installation
```
See: https://bintray.com/dllewellyn/kotlin-string-obfuscator


Gradle file:
repositories {
    maven {
        url "https://dl.bintray.com/dllewellyn/kotlin-string-obfuscator"
    }
}

dependencies {
    implementation 'com.secure.obfuscated:kotlin-string-obfuscator:1.0.0' // Check latest version first! 
}
```

Generating obfuscating strings

Use the tool here:

https://github.com/dllewellyn/kotlin-obufscated-string-generator/releases/download/v1.0.0/obufscated-generator-0.1-all.jar

Like so:

```java -jar obufscated-generator-0.1-all.jar -v Test```

Generates

```
Key: dwi4 Obfuscated string 48-18-26-64

"48-18-26-64".deobfuscate("dwi4")
```

Usage

```
class SampleProperty {
    val obfuscated: String
        get() = xorDeobfuscator("Test", "27-16-7-4")

    val obfuscatedKotlin: String
        get() = "27-16-7-4".deobfuscate("Test")

}
```
