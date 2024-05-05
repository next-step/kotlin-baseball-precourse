fun main() {
    do {
        val baseBallGame = Game()
        baseBallGame.gameStart()
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        var gameRestart: String? = readLine()
        while (gameRestart != "1" && gameRestart != "2") {
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            gameRestart = readLine()
        }
    } while (gameRestart == "1")
}