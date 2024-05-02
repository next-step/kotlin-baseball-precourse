fun main() {
    runSystem()
}

// 상대방 기능
fun createAnswer(): List<Int> {
    val range = (1..9)
    val numbers = mutableSetOf<Int>()
    while (numbers.size < 3) {
        numbers.add(range.random())
    }
    val answer: List<Int> = numbers.toList()
    return answer
}

// 시스템 기능
fun runSystem() {
    do {
        startGame()
    } while (restartGame())
    println("애플리케이션을 종료합니다.")
}

fun startGame() {
}

fun compareNumber() {
}

fun checkScore() {
}

fun restartGame(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var restart: Boolean = false
    var opt: Int = 0
    try {
        opt = readln().toInt()
    }
    catch (exception: Exception) {
        throw IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.")
    }

    if (opt == 1) {
        restart = true
    } else if (opt == 2) {
        restart = false
    } else {
        println("1 또는 2를 입력하세요.")
        restart = restartGame()
    }
    return restart
}