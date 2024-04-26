private sealed class GameState {
    data object BeforeStart: GameState()
    data object OnGoing: GameState()
    data object GameEnd: GameState()
}
private class GameController {
    var gameState: GameState = GameState.BeforeStart
}

fun main() {

}