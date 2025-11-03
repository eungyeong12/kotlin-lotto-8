package domain

import constant.Constants.MAX_NUMBER
import constant.Constants.MIN_NUMBER
import exception.ErrorMessage
import util.Parser
import util.Validator

@JvmInline
value class BonusNumber private constructor(val value: Int) {

    fun isBonusNumberMatch(numbers: List<Int>): Boolean {
        return value in numbers
    }

    companion object {
        fun from(input: String, winningNumbers: WinningNumbers): BonusNumber {
            Validator.validateNotBlank(input)
            val n = Parser.parseToNumber(input)
            validate(n, winningNumbers)
            return BonusNumber(n)
        }

        private fun validate(n: Int, winningNumbers: WinningNumbers) {
            require(n in MIN_NUMBER..MAX_NUMBER) { ErrorMessage.LOTTO_NUMBERS_RANGE_INVALID }
            require(n !in winningNumbers.value) { ErrorMessage.LOTTO_NUMBERS_DUPLICATE }
        }
    }
}