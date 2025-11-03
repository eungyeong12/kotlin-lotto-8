package lotto.domain

import domain.Amount
import domain.LottoNumberGenerator
import domain.Lottos
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FixedLottoNumberGenerator(private val numbers: List<Int>): LottoNumberGenerator {
    override fun generate() = numbers
}

@DisplayName("로또 발행 테스트")
class LottosTest {

    @Test
    fun `금액과 LottoNumberGenerator를 입력받아 정상적으로 로또를 발행한다`() {
        // given
        val amount = Amount.from("10000")

        // when
        val lottos = Lottos.generate(
            amount,
            FixedLottoNumberGenerator(listOf(6, 5, 4, 3, 2, 1))
        ).toDto()

        // then
        assertEquals(lottos.count, 10)
        assertEquals(lottos.lottos[0].numbers, listOf(1, 2, 3, 4, 5, 6))
    }
}