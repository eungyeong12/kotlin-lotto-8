package lotto.exception

enum class ErrorMessage(val message: String) {
    BLANK_AMOUNT_INPUT("구입 금액을 입력해 주세요."),
    AMOUNT_NOT_INTEGER("구입 금액은 정수여야 합니다."),
    AMOUNT_LESS_THAN_THOUSAND("구입 금액은 1,000원 이상이어야 합니다."),
    AMOUNT_NOT_THOUSAND_UNIT("구입 금액은 1,000원 단위여야 합니다."),
    LOTTO_COUNT_NOT_SIX("로또 번호는 6개여야 합니다."),
    BLANK_WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    WINNING_NUMBER_NOT_INTEGER("정수가 아닌 번호가 있습니다."),
    WRONG_RANGE_WINNING_NUMBER("당첨 번호는 1에서 45 사이여야 합니다."),
    WINNING_NUMBER_NOT_SIX("당첨 번호는 6개여야 합니다."),
    DUPLICATE_WINNING_NUMBER("당첨 번호는 중복되지 않아야 합니다."),
    BLANK_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    BONUS_NUMBER_NOT_INTEGER("보너스 번호는 정수여야 합니다."),
    WRONG_RANGE_BONUS_NUMBER("보너스 번호는 1에서 45 사이여야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");

    val errorMessage: String get() = "[ERROR] $message"
}