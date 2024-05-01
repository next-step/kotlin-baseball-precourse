import engine.io.NumberGenerator
import kotlin.random.Random

class RandomNumberGenerator: NumberGenerator{
    override fun generate(count: Int): List<Int> {
        val numbers = mutableSetOf<Int>()
        while (numbers.size < count) {
            val randomNumber = Random.nextInt(1, 10)
            numbers.add(randomNumber)
        }
        return numbers.toList()
    }
}