package lotto.controller

import lotto.domain.Amount
import lotto.domain.BonusNumber
import lotto.domain.LottoMachine
import lotto.domain.LottoResult
import lotto.domain.RandomNumbersProvider
import lotto.domain.WinningNumber
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    fun run() {
        val amount = getAmount()
        val lottoMachine = LottoMachine.generateLotto(amount, RandomNumbersProvider())
        OutputView.displayPurchasedLotto(lottoMachine.getPurchasedLotto())

        val winningNumber = getWinningNumber()
        val bonusNumber = getBonusNumber(winningNumber)

        val result = LottoResult(lottoMachine.getRanks(winningNumber, bonusNumber))
    }

    private fun getAmount(): Amount =
        executeWithRetry(
            { OutputView.displayAmountInputPrompt() },
        ) {
            Amount.from(InputView.readInput())
        }

    private fun getWinningNumber(): WinningNumber =
        executeWithRetry(
            { OutputView.displayWinningNumberInputPrompt() },
        ) {
            WinningNumber.from(InputView.readInput())
        }

    private fun getBonusNumber(winningNumber: WinningNumber): BonusNumber =
        executeWithRetry(
            { OutputView.displayBonusNumberInputPrompt() },
        ) {
            BonusNumber.from(InputView.readInput(), winningNumber)
        }

    private fun <T> executeWithRetry(prompt: () -> Unit, block: () -> T): T {
        while (true) {
            try {
                prompt()
                return block()
            } catch (e: IllegalArgumentException) {
                OutputView.displayErrorMessage(e.message.toString())
            }
        }
    }
}