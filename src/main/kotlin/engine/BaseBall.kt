package engine

import engine.io.Input
import engine.io.NumberGenerator
import engine.io.Output

class BaseBall constructor(
    private val generator: NumberGenerator,
    private val input: Input,
    private val output: Output
) : Runnable {
    private val COUNT_OF_NUMBERS: Int = 3

    override fun run() {
        val answer = generator.generate(COUNT_OF_NUMBERS)

        while (true) {
            val inputString: String = input.input("숫자를 입력해 주세요 : ")
            val inputNumber: List<Int>? = parse(inputString)

            if (inputNumber == null) {
                output.displayInputError()
                break   // or continue?
            }
        }
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