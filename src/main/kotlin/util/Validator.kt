package util

import exception.ErrorMessage

object Validator {
    fun validateNotBlank(input: String) {
        require(input.isNotBlank()) { ErrorMessage.INPUT_BLANK }
    }
}