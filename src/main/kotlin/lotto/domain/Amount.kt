package lotto.domain

import lotto.exception.ErrorMessage
import lotto.parser.Parser.parseToNumber
import lotto.validator.Validator.validateNotBlank

@JvmInline
value class Amount private constructor(
    val value: Int
){
    init {
        require(value >= MIN) { ErrorMessage.AMOUNT_LESS_THAN_THOUSAND }
        require(value % UNIT == 0) { ErrorMessage.AMOUNT_NOT_THOUSAND_UNIT }
    }

    companion object {
        private const val MIN = 1_000
        private const val UNIT = 1_000

        fun from(input: String): Amount {
            validateNotBlank(input, ErrorMessage.BLANK_AMOUNT_INPUT)
            val number = parseToNumber(input, ErrorMessage.AMOUNT_NOT_INTEGER)
            return Amount(number)
        }
    }
}