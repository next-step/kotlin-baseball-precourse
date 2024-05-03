package utils

import role.Computer
import utils.Constraints.DIGIT_LENGTH
import utils.Constraints.MAX_DIGIT
import utils.Constraints.MIN_DIGIT
import kotlin.random.Random

object computer {
    fun create(): Computer {
        val computers = linkedSetOf<Int>()
        while (computers.size < DIGIT_LENGTH) {
            val randomNumber = Random.nextInt(MIN_DIGIT, MAX_DIGIT)
            computers.add(randomNumber)
        }
        return Computer(computers.toList())
    }
}