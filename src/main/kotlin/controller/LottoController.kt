package controller

import domain.Amount
import domain.BonusNumber
import domain.Lottos
import domain.RandomLottoNumberGenerator
import domain.WinningNumbers
import view.InputView
import view.OutputView

class LottoController {
    fun run() {
        val amount = getPurchaseAmount()
        val lottos = generateLottos(amount)
        OutputView.displayLottoCountAndNumbers(lottos.toDto())

        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
    }
}

private fun getPurchaseAmount(): Amount {
    while (true) {
        try {
            OutputView.displayPurchaseAmountPrompt()
            return Amount.from(InputView.readInput())
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

