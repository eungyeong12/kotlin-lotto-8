package view

import domain.Rank
import domain.dto.LottoDto
import domain.dto.LottosDto

object OutputView {
    private const val PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요."
    private const val LOTTO_COUNT_MESSAGE_SUFFIX = "개를 구매했습니다."
    private const val WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요."
    private const val BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요."
    private const val WINNING_STATISTICS = "당첨 통계"
    private const val DIVIDER = "---"
    private const val THREE_MATCH_RESULT = "3개 일치 (5,000원) - %d개"
    private const val FOUR_MATCH_RESULT = "4개 일치 (50,000원) - %d개"
    private const val FIVE_MATCH_RESULT = "5개 일치 (1,500,000원) - %d개"
    private const val FIVE_MATCH_AND_BONUS_MATCH_RESULT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
    private const val SIX_MATCH_RESULT = "6개 일치 (2,000,000,000원) - %d개"
    private const val RATE_OF_RETURN_MESSAGE = "총 수익률은 %,.1f%%입니다."

    fun displayPurchaseAmountPrompt() {
        println(PURCHASE_AMOUNT_PROMPT)
    }

    fun displayLottoCountAndNumbers(lottos: LottosDto) {
        printLottoCount(lottos.count)
        printLottoNumbers(lottos.lottos)
    }

    fun displayWinningNumbersPrompt() {
        println("\n$WINNING_NUMBERS_PROMPT")
    }

    fun displayBonusNumberPrompt() {
        println("\n$BONUS_NUMBER_PROMPT")
    }

    fun displayLottoResult(winningResults: Map<Rank, Int>, rateOfReturn: Double) {
        println("\n$WINNING_STATISTICS\n$DIVIDER")
        printLottoWinningResults(winningResults)
        printLottoRateOfReturn(rateOfReturn)
    }

    fun displayErrorMessage(message: String) {
        println(message)
    }

    private fun printLottoCount(count: Int) {
        println("\n${count}$LOTTO_COUNT_MESSAGE_SUFFIX")
    }

    private fun printLottoNumbers(lottos: List<LottoDto>) {
        lottos.forEach {
            println(it.numbers)
        }
    }

    private fun printLottoWinningResults(results: Map<Rank, Int>) {
        listOf(
            Rank.THREE_MATCH to THREE_MATCH_RESULT,
            Rank.FOUR_MATCH to FOUR_MATCH_RESULT,
            Rank.FIVE_MATCH to FIVE_MATCH_RESULT,
            Rank.FIVE_MATCH_AND_BONUS_MATCH to FIVE_MATCH_AND_BONUS_MATCH_RESULT,
            Rank.SIX_MATCH to SIX_MATCH_RESULT
        ).forEach { (rank, format) ->
            println(format.format(results[rank] ?: 0))
        }
    }

    private fun printLottoRateOfReturn(rateOfReturn: Double) {
        println(String.format(RATE_OF_RETURN_MESSAGE, rateOfReturn))
    }
}

