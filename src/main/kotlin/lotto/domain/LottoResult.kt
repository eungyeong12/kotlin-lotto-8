package lotto.domain

class LottoResult(
    val result: Map<Rank, Int>
){
    private fun calculateTotalPrize(): Int {
        return result.map { (rank, count) ->
            rank.calculatePrize(count)
        }.sum()
    }
}