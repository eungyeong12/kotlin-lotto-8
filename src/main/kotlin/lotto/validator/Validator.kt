package lotto.validator

object Validator {

    fun validateNotBlank(input: String, errorMessage: String) {
        require(input.isNotBlank()) { errorMessage }
    }
}