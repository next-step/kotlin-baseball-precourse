package engine

import RandomNumberGenerator
import engine.io.Input
import engine.io.NumberGenerator
import engine.io.Output

class BaseBall constructor(
    private val generator: RandomNumberGenerator,
    private val input: Input,
    private val output: Output
) : Runnable {
    private val COUNT_OF_NUMBERS: Int = 3

    override fun run() {
        val answer:List<Int> = generator.generate(COUNT_OF_NUMBERS)

        while (true) {
            val inputString: String = input.input("숫자를 입력해 주세요 : ")
            val inputNumber: List<Int>? = parse(inputString)

            if (inputNumber == null) {
                output.displayInputError()
                break   // or continue?
            }

            var ballCount = returnBallCount(answer, inputNumber)
            output.displayBallCount(ballCount)

            // 스트라이크 및 볼 판정 로직
        }
    }
    fun Hello(){

    }
    fun returnBallCount(answer:List<Int>, inputNumbers:List<Int>): BallCount {
        var strikes = 0
        var balls = 0

        answer.forEachIndexed { i, n ->
            inputNumbers.forEachIndexed {j, m ->
                if (n == m) {
                    if (i == j) strikes++
                    else balls++
                }
            }
        }
        return BallCount(strikes, balls)
    }

    fun parse(inputString: String): List<Int>? {
        if (inputString.length != COUNT_OF_NUMBERS) return null

        val distinctNumbers = inputString
            .filter { it.isDigit() }
            .map { it.toString().toInt() }
            .filter { it in 1..9 }
            .distinct()

        if (distinctNumbers.size != COUNT_OF_NUMBERS) return null

        return distinctNumbers
    }
}