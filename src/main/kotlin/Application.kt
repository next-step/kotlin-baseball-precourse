
fun main() {
    do {
        val game = BaseballGame()
        game.playGame()
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val answer : String? = readLine()
        if (answer == "2") break
    } while (answer=="1")
}
