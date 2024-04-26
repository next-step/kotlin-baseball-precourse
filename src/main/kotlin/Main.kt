private sealed class GameState {
    data object BeforeStart: GameState()
    data object OnGoing: GameState()
    data object GameEnd: GameState()
}

private class GameController {
    var gameState: GameState = GameState.BeforeStart
}

private class Computer {
    val number: Array<Int> = setNumber()

    private fun setNumber(): Array<Int> {
        val number: Array<Int> = Array(3) { 0 }
        number[0] = getRandomNumber(number)
        number[1] = getRandomNumber(number)
        number[2] = getRandomNumber(number)

        return number
    }

    private fun getRandomNumber(nums: Array<Int>): Int {
        var result = (1..9).random()
        while (nums.contains(result)) {
            result = (1..9).random()
        }
        return result
    }

    fun printResult() {

    }
}

fun main() {

}