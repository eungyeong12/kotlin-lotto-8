package domain

import constant.Constants.LOTTO_COUNT
import constant.Constants.MAX_NUMBER
import constant.Constants.MIN_NUMBER
import exception.ErrorMessage
import util.Parser
import util.Validator

@JvmInline
value class WinningNumbers private constructor(val value: List<Int>){

    fun getMatchCount(numbers: List<Int>): Int {
        return value.count { it in numbers }
    }

    companion object {
        fun from(input: String): WinningNumbers {
            Validator.validateNotBlank(input)
            val numbers = Parser.splitByComma(input)
                .map { Parser.parseToNumber(it) }
            validate(numbers)
            return WinningNumbers(numbers.toList())
        }

        private fun validate(numbers: List<Int>) {
            require(numbers.size == LOTTO_COUNT) { ErrorMessage.LOTTO_NUMBER_COUNT_INVALID }
            require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { ErrorMessage.LOTTO_NUMBERS_RANGE_INVALID }
            require(numbers.size == numbers.distinct().size) { ErrorMessage.LOTTO_NUMBERS_DUPLICATE }
        }
    }
}
