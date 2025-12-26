package lotto.view

import lotto.domain.Rank
import lotto.domain.dto.LottoDto

object OutputView {
    private const val AMOUNT_INPUT_PROMPT = "구입금액을 입력해 주세요."
    private const val PURCHASED_COUNT_PROMPT = "개를 구매했습니다."
    private const val WINNING_NUMBER_INPUT_PROMPT = "당첨 번호를 입력해 주세요."
    private const val BONUS_NUMBER_INPUT_PROMPT = "보너스 번호를 입력해 주세요."
    private const val RESULT_PROMPT = "당첨 통계"
    private const val DASH = "---"
    private const val THREE_MATCH_RESULT = "3개 일치 (5,000원) - %d개"
    private const val FOUR_MATCH_RESULT = "4개 일치 (50,000원) - %d개"
    private const val FIVE_MATCH_RESULT = "5개 일치 (1,500,000원) - %d개"
    private const val FIVE_MATCH_AND_BONUS_MATCH_RESULT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
    private const val SIX_MATCH_RESULT = "6개 일치 (2,000,000,000원) - %d개"
    private const val PROFIT_MESSAGE = "총 수익률은 %,.1f%%입니다."

    fun displayAmountInputPrompt() {
        println(AMOUNT_INPUT_PROMPT)
    }

    fun displayWinningNumberInputPrompt() {
        println()
        println(WINNING_NUMBER_INPUT_PROMPT)
    }

    fun displayBonusNumberInputPrompt() {
        println()
        println(BONUS_NUMBER_INPUT_PROMPT)
    }

    fun displayErrorMessage(errorMessage: String) {
        println(errorMessage)
    }

    fun displayPurchasedLotto(lottos: List<LottoDto>) {
        println()
        println("${lottos.size}$PURCHASED_COUNT_PROMPT")
        println(formatPurchasedLottoNumbers(lottos))
    }

    fun displayResult(result: Map<Rank, Int>, profit: Double) {
        println()
        println(RESULT_PROMPT)
        println(DASH)
        println(formatResult(result))
        println(String.format(PROFIT_MESSAGE, profit))
    }

    private fun formatPurchasedLottoNumbers(lotto: List<LottoDto>): String {
        return lotto.joinToString("\n") {
            it.numbers.toString()
        }
    }

    private fun formatResult(result: Map<Rank, Int>): String {
        return listOf(
            Rank.FIFTH to THREE_MATCH_RESULT,
            Rank.FOURTH to FOUR_MATCH_RESULT,
            Rank.THIRD to FIVE_MATCH_RESULT,
            Rank.SECOND to FIVE_MATCH_AND_BONUS_MATCH_RESULT,
            Rank.FIRST to SIX_MATCH_RESULT
        ).joinToString("\n") { (rank, format) ->
            format.format(result[rank] ?: 0)
        }
    }
}