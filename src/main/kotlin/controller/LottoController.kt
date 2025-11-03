package controller

import domain.Amount
import domain.Lottos
import domain.RandomLottoNumberGenerator
import domain.dto.LottosDto
import view.InputView
import view.OutputView

class LottoController {
    fun run() {
        val amount = getPurchaseAmount()
        val lottos = generateLottos(amount)
        OutputView.displayLottoCountAndNumbers(lottos.toDto())
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
    while (true) {
        try {
            return Lottos.generate(amount, RandomLottoNumberGenerator())
        } catch (e: IllegalArgumentException) {
            println(e.message.toString())
        }
    }
}
