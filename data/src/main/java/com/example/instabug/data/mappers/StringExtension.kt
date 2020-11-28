package com.example.instabug.data.mappers

internal fun String.ignoreSpecialCharacters(): String {
    val regex = "[^A-Za-z ]".toRegex()
    return regex.replace(this, " ")
}

internal fun String.toStringList(): List<String> = this.trim().split("\\s+".toRegex())