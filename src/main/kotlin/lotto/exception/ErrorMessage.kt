package lotto.exception

enum class ErrorMessage(val message: String) {
    BLANK_AMOUNT_INPUT("구입 금액을 입력해 주세요."),
    AMOUNT_NOT_INTEGER("구입 금액은 정수여야 합니다."),
    AMOUNT_LESS_THAN_THOUSAND("구입 금액은 1,000원 이상이어야 합니다."),
    AMOUNT_NOT_THOUSAND_UNIT("구입 금액은 1,000원 단위여야 합니다."),
    LOTTO_COUNT_NOT_SIX("로또 번호는 6개여야 합니다.");

    companion object {
        private const val PREFIX = "[ERROR]"
    }

    override fun toString() = "$PREFIX $message"
}