package engine

import RandomNumberGenerator
import engine.io.Input
import engine.io.NumberGenerator
import engine.io.Output
class BaseBall constructor(
    private val generator: NumberGenerator,
    private val input: Input,
    private val output: Output
) : Runnable {
    private val COUNT_OF_NUMBERS: Int = 3

    /* Game Flow
    * */
    override fun run() {
        var keepPlaying = true
        while (keepPlaying) {
            val answer = generator.generate(COUNT_OF_NUMBERS)
            var gameFinished = false

            while (!gameFinished) {
                try {
                    val inputString = input.input("숫자를 입력해 주세요 : ")
                    val inputNumbers = parse(inputString)

                    if (inputNumbers == null) {
                        throw IllegalArgumentException("잘못된 입력입니다. 올바른 형식의 숫자를 입력하세요.")
                    }

                    val ballCount = returnBallCount(answer, inputNumbers)
                    output.displayBallCount(ballCount)
                    if (ballCount.strike == COUNT_OF_NUMBERS) {
                        output.displayCorrectMessage()
                        gameFinished = true
                    }
                } catch (e: IllegalArgumentException) {
                    output.displayInputError(e.message)
                    return  // 게임 종료
                }
            }
            keepPlaying = promptForRestart()
        }
    }

    private fun promptForRestart(): Boolean {
        val choice = input.input("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return choice == "1"
    }

    /* BallCount Check : 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼 */
    fun returnBallCount(answer:List<Int>, inputNumbers:List<Int>): BallCount {
        var strikes = 0
        var balls = 0

        answer.forEachIndexed { i, n ->
            inputNumbers.forEachIndexed { j, m ->
                if (n == m) {
                    if (i == j) strikes++
                    else balls++
                }
            }
        }
        return BallCount(strikes, balls)
    }

    /* Input Validation : 1부터 9까지 서로 다른 수로 이루어진 3자리의 수
    *   (1) 입력 문자열의 길이가 3자리
    *   (2) 모두 숫자, 1부터 9까지(0 안됨), 중복 여부를 검사
    * */
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