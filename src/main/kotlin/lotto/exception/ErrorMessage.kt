package lotto.exception

enum class ErrorMessage(val message: String) {
    BLANK_INPUT("입력이 비어 있습니다."),
    NOT_NUMBER("숫자가 아닙니다.");

    val errorMessage: String get() = "[ERROR] $message"
}