package utils

import role.Computer
import kotlin.random.Random

object computer {
    fun create(): Computer {
        val computers = linkedSetOf<Int>()
        while (computers.size < 3) {
            val randomNumber = Random.nextInt(1, 9)
            computers.add(randomNumber)
        }
        return Computer(computers.toList())
    }
}
