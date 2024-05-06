class GameManager {
    private var computer: Computer = Computer()
    private val userInterface: UserInterface = UserInterface()
    private var isGameRestart: Int = 1
    private var isGameEnd: Boolean = true

    private fun initGame() {
        computer = Computer()
        isGameEnd = false
    }
}