package domain

interface LottoNumberGenerator {
    fun generate(): List<Int>
}