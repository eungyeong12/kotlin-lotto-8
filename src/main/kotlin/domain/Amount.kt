package domain

import constant.Constants.AMOUNT_UNIT
import exception.ErrorMessage
import util.Parser
import util.Validator

@JvmInline
value class Amount private constructor(val value: Int) {

    companion object {
        fun from(input: String): Amount {
            Validator.validateNotBlank(input)
            val n = Parser.parseToNumber(input)
            validate(n)
            return Amount(n)
        }

        private fun validate(n: Int) {
            require(n >= AMOUNT_UNIT) { ErrorMessage.AMOUNT_BELOW_MINIMUM }
            require(n % AMOUNT_UNIT == 0) { ErrorMessage.AMOUNT_NOT_THOUSAND_UNIT }
        }
    }
}
