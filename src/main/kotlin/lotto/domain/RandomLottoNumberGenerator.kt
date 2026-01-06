package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomLottoNumberGenerator : LottoNumberGenerator {
    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}