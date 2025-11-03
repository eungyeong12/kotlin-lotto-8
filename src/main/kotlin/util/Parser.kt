package util

import exception.ErrorMessage

object Parser {
    fun splitByComma(input: String): List<String> {
        return input.split(",")
            .map { it.trim() }
    }

    fun parseToNumber(input: String): Int {
        return requireNotNull(input.toIntOrNull()) { ErrorMessage.INPUT_NOT_INTEGER }
    }
}