package lotto.parser

object Parser {

    fun parseToNumber(input: String, errorMessage: String): Int {
        val number = input.toIntOrNull()
        requireNotNull(number) { errorMessage }
        return number
    }

    fun splitByDelimiter(input: String, delimiter: Char): List<String> {
        return input.split(delimiter)
            .map { it.trim() }
    }
}