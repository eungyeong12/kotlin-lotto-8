package lotto.domain

import lotto.constant.Constants.AMOUNT_UNIT
import lotto.exception.ErrorMessage
import lotto.parser.Parser.parseToNumber
import lotto.validator.Validator.validateNotBlank

@JvmInline
value class Amount private constructor(
    val value: Int
){
    init {
        require(value >= MIN) { ErrorMessage.AMOUNT_LESS_THAN_THOUSAND.errorMessage }
        require(value % AMOUNT_UNIT == 0) { ErrorMessage.AMOUNT_NOT_THOUSAND_UNIT.errorMessage }
    }

    companion object {
        private const val MIN = 1_000

        fun from(input: String): Amount {
            validateNotBlank(input, ErrorMessage.BLANK_AMOUNT_INPUT.errorMessage)
            val number = parseToNumber(input, ErrorMessage.AMOUNT_NOT_INTEGER.errorMessage)
            return Amount(number)
        }
    }
}