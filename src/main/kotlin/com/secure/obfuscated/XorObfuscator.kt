package com.secure.obfuscated

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

fun xorDeobfuscator(obfuscated: Any, value: String) =
    xorObfuscator(
        obfuscated::class.java.getAnnotation(Obfuscated::class.java)
            .key, value
    )
