package view

import domain.dto.LottoDto
import domain.dto.LottosDto

object OutputView {
    private const val PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요."
    private const val LOTTO_COUNT_MESSAGE_SUFFIX = "개를 구매했습니다."
    private const val WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요."
    private const val BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요."

    fun displayPurchaseAmountPrompt() {
        println(PURCHASE_AMOUNT_PROMPT)
    }

    fun displayLottoCountAndNumbers(lottos: LottosDto) {
        printLottoCount(lottos.count)
        printLottoNumbers(lottos.lottos)
    }

    fun displayWinningNumbersPrompt() {
        println(WINNING_NUMBERS_PROMPT)
    }

    fun displayBonusNumberPrompt() {
        println(BONUS_NUMBER_PROMPT)
    }

    private fun printLottoCount(count: Int) {
        println("\n${count}$LOTTO_COUNT_MESSAGE_SUFFIX")
    }

    private fun printLottoNumbers(lottos: List<LottoDto>) {
        lottos.forEach {
            println(it.numbers)
        }
        println()
    }
}

