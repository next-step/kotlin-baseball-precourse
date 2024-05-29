class GameManager {
    fun manageGame(gameStateManager: GameStateManager) {

        while (gameStateManager.getGameState() != GameState.End) {
            gameStateManager.changeGameState(GameState.OnGoing)

            val computer = Computer(RandomNumberGenerator().setNumber())
            val player = Player()
            val inputValidator = InputValidator()

            playGame(gameStateManager, player, computer, inputValidator)
            val userInput = player.getUserGameStatusInput(inputValidator)
            when (userInput) {
                1 -> continue
                2 -> gameStateManager.changeGameState(GameState.End)
            }
        }
    }

    private fun playGame(gameStateManager: GameStateManager, player: Player, computer: Computer, inputValidator: InputValidator) {
        while (gameStateManager.getGameState() == GameState.OnGoing) {
            val userInput = player.getUserNumberInput(inputValidator)
            computer.printResult(userInput, gameStateManager)
        }
    }
}