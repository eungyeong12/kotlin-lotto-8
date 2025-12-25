package lotto.view

import lotto.domain.dto.LottoDto
import lotto.domain.dto.PurchasedLotto

object OutputView {
    private const val AMOUNT_INPUT_PROMPT = "구입금액을 입력해 주세요."
    private const val PURCHASED_COUNT_PROMPT = "개를 구매했습니다."
    private const val WINNING_NUMBER_INPUT_PROMPT = "당첨 번호를 입력해 주세요."

    fun displayAmountInputPrompt() {
        println(AMOUNT_INPUT_PROMPT)
    }

    fun displayWinningNumberInputPrompt() {
        println(WINNING_NUMBER_INPUT_PROMPT)
    }

    fun displayErrorMessage(errorMessage: String) {
        println(errorMessage)
    }

    fun displayPurchasedLotto(lottos: PurchasedLotto) {
        println()
        println("${lottos.count}$PURCHASED_COUNT_PROMPT")
        println(formatPurchasedLottoNumbers(lottos.lottos))
    }

    private fun formatPurchasedLottoNumbers(lotto: List<LottoDto>): String {
        return lotto.joinToString("\n") {
            it.numbers.toString()
        }
    }
}