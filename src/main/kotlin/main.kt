fun main() { //기본 게임 구현
    val game = BaseballGame()
    game.play()
}

class BaseballGame {
    val targetNumbers: List<Int> = generateTargetNumbers()
}