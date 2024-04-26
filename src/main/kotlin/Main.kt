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
        return arrayOf()
    }


    fun printResult() {

    }
}
fun main() {

}