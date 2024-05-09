class GameStateManager {
    private var gameState: GameState = GameState.IsLoading

    fun changeGameState(state: GameState) {
        this.gameState = state
    }

    fun getGameState(): GameState {
        return gameState
    }
}