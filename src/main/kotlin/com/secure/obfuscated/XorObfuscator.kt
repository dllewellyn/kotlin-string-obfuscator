package com.secure.obfuscated

import kotlin.reflect.full.findAnnotation

fun xorObfuscator(key: String, value: String): String {
    if (key.length != value.length) {
        throw WrongLengthException()
    }

    val builder = StringBuilder()

    for (i in key.indices) {
        builder.append(key[i].toInt().xor(value[i].toInt()).toString())
        builder.append("-")
    }

    return builder.toString().removeSuffix("-")
}

fun xorDeobfuscator(key: String, value: String): String {
    val builder = StringBuilder()

    value.split("-").forEachIndexed { index, v ->
        builder.append(v.toInt().xor(key[index].toInt()).toChar())
    }

    return builder.toString()
}

fun String.deobfuscate(key: String) = xorDeobfuscator(key, this)

fun String.deobfuscate(obfuscated: Obfuscated?) = obfuscated?.key?.let {
    xorDeobfuscator(it, this)
} ?: throw IllegalArgumentException("Property must have Obfuscated annotation")

fun xorDeobfuscator(obfuscated: Any, value: String) =
    xorObfuscator(
        obfuscated::class.java.getAnnotation(Obfuscated::class.java)
            .key, value
    )
