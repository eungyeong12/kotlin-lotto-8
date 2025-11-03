package exception

enum class ErrorMessage(val message: String) {
    INPUT_BLANK("입력값이 비어 있습니다."),
    INPUT_NOT_INTEGER("정수가 아닙니다."),
    AMOUNT_BELOW_MINIMUM("구입 금액은 1,000원 이상이어야 합니다."),
    AMOUNT_NOT_THOUSAND_UNIT("금액은 1,000원 단위여야 합니다."),
    LOTTO_NUMBER_COUNT_INVALID("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_RANGE_INVALID("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBERS_DUPLICATE("로또 번호는 중복될 수 없습니다.");

    companion object {
        private const val PREFIX = "[ERROR]"
    }

    override fun toString() = "$PREFIX $message"
}
