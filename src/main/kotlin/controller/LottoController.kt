package controller

import domain.*
import view.InputView
import view.OutputView

class LottoController {
    fun run() {
        val (amount, lottos) = getAmountAndGenerateLottos()
        OutputView.displayLottoCountAndNumbers(lottos.toDto())

        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)

        val winningResults = lottos.getWinningResults(winningNumbers, bonusNumber)
        val rateOfReturn = lottos.getRateOfReturn(winningResults, amount)
        OutputView.displayLottoResult(winningResults, rateOfReturn)
    }
}

private fun getAmountAndGenerateLottos(): Pair<Amount, Lottos> =
    executeWithRetry(
        { OutputView.displayPurchaseAmountPrompt() }
    ) {
        val amount = Amount.from(InputView.readInput())
        val lottos = generateLottos(amount)
        Pair(amount, lottos)
    }

private fun generateLottos(amount: Amount): Lottos =
    Lottos.generate(amount, RandomLottoNumberGenerator())


private fun getWinningNumbers(): WinningNumbers =
    executeWithRetry(
        { OutputView.displayWinningNumbersPrompt() }
    ) {
        WinningNumbers.from(InputView.readInput())
    }

private fun getBonusNumber(winningNumbers: WinningNumbers): BonusNumber =
    executeWithRetry(
        { OutputView.displayBonusNumberPrompt() }
    ) {
        BonusNumber.from(InputView.readInput(), winningNumbers)
    }

private fun <T> executeWithRetry(prompt: () -> Unit, block: () -> T): T {
    while (true) {
        try {
            prompt()
            return block()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
