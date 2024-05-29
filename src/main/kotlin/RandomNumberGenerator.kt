class RandomNumberGenerator {
    fun setNumber(): Array<Int> {
        val number: Array<Int> = Array(3) { 0 }
        number[0] = getRandomNumber(number)
        number[1] = getRandomNumber(number)
        number[2] = getRandomNumber(number)

        return number
    }

    private fun getRandomNumber(numbers: Array<Int>): Int {
        var result = (1..9).random()
        while (numbers.contains(result)) {
            result = (1..9).random()
        }
        return result
    }
}