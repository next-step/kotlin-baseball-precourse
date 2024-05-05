import kotlin.random.Random

class Game {
    private val threeNumber: MutableList<Int>

    init {
        threeNumber = generateRandomNumber()
    }

    private fun generateRandomNumber(): MutableList<Int> {
        val numbers = mutableListOf<Int>()
        while (numbers.size < 3) {
            val randomNumber = Random.nextInt(1, 10)
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber)
            }
        }
        return numbers
    }

}
