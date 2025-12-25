package lotto.domain

import com.sun.jdi.Value
import lotto.constant.Constants.LOTTO_COUNT
import lotto.constant.Constants.LOTTO_MAX_NUMBER
import lotto.constant.Constants.LOTTO_MIN_NUMBER
import lotto.exception.ErrorMessage
import lotto.parser.Parser.parseToNumber
import lotto.parser.Parser.splitByDelimiter
import lotto.validator.Validator.validateNotBlank

@JvmInline
value class WinningNumber private constructor(
    val value: List<Int>
) {
    init {
        require(value.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) {
            ErrorMessage.WRONG_RANGE_WINNING_NUMBER
        }
        require(value.size == LOTTO_COUNT) { ErrorMessage.WINNING_NUMBER_NOT_SIX }
        require(value.size == value.distinct().size) { ErrorMessage.DUPLICATE_WINNING_NUMBER }
    }

    fun contains(number: Int) = value.contains(number)

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