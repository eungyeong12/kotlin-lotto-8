package view

import domain.dto.LottoDto
import domain.dto.LottosDto

object OutputView {
    private const val PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요."
    private const val LOTTO_COUNT_MESSAGE_SUFFIX = "개를 구매했습니다."

    fun displayPurchaseAmountPrompt() {
        println(PURCHASE_AMOUNT_PROMPT)
    }

    fun displayLottoCountAndNumbers(lottos: LottosDto) {
        printLottoCount(lottos.count)
        printLottoNumbers(lottos.lottos)
    }

    private fun printLottoCount(count: Int) {
        println("\n${count}$LOTTO_COUNT_MESSAGE_SUFFIX")
    }

    private fun printLottoNumbers(lottos: List<LottoDto>) {
        lottos.forEach {
            println(it.numbers)
        }
    }
}
