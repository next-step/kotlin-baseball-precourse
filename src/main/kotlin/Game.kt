import kotlin.random.Random

class Game {
    fun generateRandomNumber() : List<Int> {
        val NUMBERS = mutableListOf<Int>()

        while (NUMBERS.size < 3) {
            val RANDOM_NUMBER = Random.nextInt(1, 10)

            if (!NUMBERS.contains(RANDOM_NUMBER)) {
                NUMBERS.add(RANDOM_NUMBER)
            }
        }

        return NUMBERS
    }
}