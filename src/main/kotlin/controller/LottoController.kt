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
    }
}

private fun getAmountAndGenerateLottos(): Pair<Amount, Lottos> {
    while (true) {
        try {
            OutputView.displayPurchaseAmountPrompt()
            val amount = Amount.from(InputView.readInput())
            val lottos = generateLottos(amount)
            return Pair(amount, lottos)
        } catch (e: IllegalArgumentException) {
            println(e.message.toString())
        }
    }
}

private fun generateLottos(amount: Amount): Lottos {
    return Lottos.generate(amount, RandomLottoNumberGenerator())
}

private fun getWinningNumbers(): WinningNumbers {
    while (true) {
        try {
            OutputView.displayWinningNumbersPrompt()
            return WinningNumbers.from(InputView.readInput())
        } catch (e: IllegalArgumentException) {
            println(e.message.toString())
        }
    }
}

private fun getBonusNumber(winningNumbers: WinningNumbers): BonusNumber {
    while (true) {
        try {
            OutputView.displayBonusNumberPrompt()
            return BonusNumber.from(InputView.readInput(), winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message.toString())
        }
    }
}

