package domain

import exception.ErrorMessage

@JvmInline
value class Amount private constructor(val value: Int) {

    companion object {
        private const val AMOUNT_UNIT = 1000

        fun from(input: String): Amount {
            require(input.isNotBlank()) { ErrorMessage.INPUT_BLANK }
            val n = requireNotNull(input.toIntOrNull()) { ErrorMessage.INPUT_NOT_INTEGER }
            require(n >= AMOUNT_UNIT) { ErrorMessage.AMOUNT_BELOW_MINIMUM }
            require(n % AMOUNT_UNIT == 0) { ErrorMessage.AMOUNT_NOT_THOUSAND_UNIT }
            return Amount(n)
        }
    }
}
