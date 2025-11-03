package domain

import camp.nextstep.edu.missionutils.Randoms

class RandomLottoNumberGenerator: LottoNumberGenerator {
    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT)
    }

    companion object {
        private const val MIN: Int = 1
        private const val MAX: Int = 45
        private const val COUNT: Int = 6
    }
}