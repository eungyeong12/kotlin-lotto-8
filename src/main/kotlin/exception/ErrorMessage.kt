package exception

enum class ErrorMessage(val message: String) {
    AMOUNT_BLANK("구입 금액은 비어있을 수 없습니다."),
    AMOUNT_NOT_INTEGER("구입 금액은 정수여야 합니다."),
    AMOUNT_BELOW_MINIMUM("구입 금액은 1,000원 이상이어야 합니다."),
    AMOUNT_NOT_THOUSAND_UNIT("금액은 1,000원 단위여야 합니다.");

    companion object {
        private const val PREFIX = "[ERROR]"
    }

    override fun toString() = "$PREFIX $message"
}
