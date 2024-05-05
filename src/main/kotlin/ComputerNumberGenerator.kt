object ComputerNumberGenerator {
    fun generate(): List<Int> {
        val numbers = mutableListOf<Int>()
        while (numbers.size < 3) {
            val randomNum = (1..9).random()
            if (randomNum !in numbers) {
                numbers.add(randomNum)
            }
        }
        return numbers
    }
}
