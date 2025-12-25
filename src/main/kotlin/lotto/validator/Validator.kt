package lotto.validator

import lotto.exception.ErrorMessage

object Validator {

    fun validateNotBlank(input: String, errorMessage: ErrorMessage) {
        require(input.isNotBlank()) { errorMessage }
    }
}