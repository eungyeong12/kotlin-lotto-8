package lotto.domain

import lotto.constant.Constants.LOTTO_MAX_NUMBER
import lotto.constant.Constants.LOTTO_MIN_NUMBER
import lotto.exception.ErrorMessage
import lotto.parser.Parser.parseToNumber
import lotto.validator.Validator.validateNotBlank

@JvmInline
value class BonusNumber private constructor(
    val value: Int
){

    companion object {
        fun from(input: String, winningNumber: WinningNumber): BonusNumber {
            validateNotBlank(input, ErrorMessage.BLANK_BONUS_NUMBER)
            val number = parseToNumber(input, ErrorMessage.BONUS_NUMBER_NOT_INTEGER)
            validateBonusNumber(number, winningNumber)
            return BonusNumber(number)
        }

        private fun validateBonusNumber(number: Int, winningNumber: WinningNumber) {
            require(number in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) {
                ErrorMessage.WRONG_RANGE_BONUS_NUMBER
            }
            require(!winningNumber.contains(number)) { ErrorMessage.DUPLICATE_BONUS_NUMBER }
        }
    }
}