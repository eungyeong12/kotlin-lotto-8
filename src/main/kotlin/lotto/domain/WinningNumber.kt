package lotto.domain

import lotto.constant.Constants.LOTTO_COUNT
import lotto.constant.Constants.LOTTO_MAX_NUMBER
import lotto.constant.Constants.LOTTO_MIN_NUMBER
import lotto.exception.ErrorMessage
import lotto.parser.Parser.parseToNumber
import lotto.parser.Parser.splitByDelimiter
import lotto.validator.Validator.validateNotBlank

class WinningNumber private constructor(
    val numbers: List<Int>
) {
    init {
        require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) {
            ErrorMessage.WRONG_RANGE_WINNING_NUMBER
        }
        require(numbers.size == LOTTO_COUNT) { ErrorMessage.WINNING_NUMBER_NOT_SIX }
        require(numbers.size == numbers.distinct().size) { ErrorMessage.DUPLICATE_WINNING_NUMBER }
    }

    companion object {
        private const val DELIMITER = ','

        fun from(input: String): WinningNumber {
            validateNotBlank(input, ErrorMessage.BLANK_WINNING_NUMBER_INPUT)
            val tokens = splitByDelimiter(input, DELIMITER)
            return WinningNumber(tokens.map {
                parseToNumber(it, ErrorMessage.WINNING_NUMBER_NOT_INTEGER)
            })
        }
    }
}