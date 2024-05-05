import kotlin.random.Random

fun main() {
    val tmp = mutableListOf<Int>()
    while (tmp.size < 3) {
        tmp.add(Random.nextInt(1, 10))
    }
    val tmpArray = tmp.toIntArray()

    println("세 개의 숫자를 입력하세요(123처럼 빈칸 없이): ")
    val input = readLine()
    val inputNum = mutableListOf<Int>()

    if (input == null || input.length != 3) {
        throw IllegalArgumentException("올바른 입력값이 아닙니다!")
    } else {
        for (char in input) {
            val num = char.toString().toInt()
            inputNum.add(num)
        }
    }

    check(inputNum.toIntArray(), tmpArray)
}

fun check(guess: IntArray, answer: IntArray) {
    var strike = 0
    var ball = 0

    for (i in guess.indices) {
        if (guess[i] == answer[i]) {
            strike++
        } else if (guess.contains(answer[i])) {
            ball++
        }
    }

    if (strike == 3) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        exit()
    } else if (strike > 0 && ball > 0) {
        println("$strike 스트라이크, $ball 볼")
    } else if (strike > 0) {
        println("$strike 스트라이크")
    } else if (ball > 0) {
        println("$ball 볼")
    } else {
        println("낫싱")
    }
}

fun exit() {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val choice = readLine()
    when (choice) {
        "1" -> main()
        "2" -> return
        else -> {
            println("잘못된 입력입니다.")
            exit()
        }
    }
}