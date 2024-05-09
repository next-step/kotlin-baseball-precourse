class GameManager {
    fun manageGame(gameStateManager: GameStateManager) {

        while (gameStateManager.getGameState() != GameState.End) {
            gameStateManager.changeGameState(GameState.OnGoing)

            val computer = Computer(RandomNumberGenerator().setNumber())
            val player = Player()
            val inputChecker = InputChecker()

            playGame(gameStateManager, player, computer, inputChecker)
            val userInput = player.getUserGameStatusInput(inputChecker)
            when (userInput) {
                1 -> continue
                2 -> gameStateManager.changeGameState(GameState.End)
            }
        }
    }

    private fun playGame(gameStateManager: GameStateManager, player: Player, computer: Computer, inputChecker: InputChecker) {
        while (gameStateManager.getGameState() == GameState.OnGoing) {
            val userInput = player.getUserNumberInput(inputChecker)
            computer.printResult(userInput, gameStateManager)
        }
    }
}