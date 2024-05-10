import kotlin.random.Random

fun createNum(): MutableList<Int> {
    val numList: MutableList<Int> = mutableListOf()
    while (numList.size < 3) {
        val num: Int = Random.nextInt(1, 10)
        if (!numList.contains(num)) {
            numList.add(num)
        }
    }
    return numList
}

fun checkNum(): MutableList<Int> {
    val checkNumList: MutableList<Int> = mutableListOf()
    print("숫자를 입력해 주세요 : ")
    val input = readLine()?.trim() ?: throw IllegalArgumentException("입력 값이 없습니다.")
    val num = input.toIntOrNull() ?: throw IllegalArgumentException("숫자로 변환할 수 없는 입력입니다.")

    if (input.length != 3) throw IllegalArgumentException("3자리 숫자를 입력해야 합니다.")

    val hundredDigit = num / 100
    val tenDigit = (num / 10) % 10
    val oneDigit = num % 10

    if (hundredDigit == tenDigit || hundredDigit == oneDigit || tenDigit == oneDigit) {
        throw IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.")
    }

    checkNumList.add(hundredDigit)
    checkNumList.add(tenDigit)
    checkNumList.add(oneDigit)

    return checkNumList
}

fun isCorrect(list1: MutableList<Int>, list2: MutableList<Int>): Boolean {
    var strike = 0
    var ball = 0

    for (i in 0..2) {
        if (list1[i] == list2[i])
            strike += 1
        else if (list2.contains(list1[i]))
            ball += 1
    }

    when {
        strike == 3 -> {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            return true
        }
        strike > 0 && ball > 0 -> println("${ball}볼 ${strike}스트라이크")
        strike > 0 && ball <= 0 -> println("${strike}스트라이크")
        strike <= 0 && ball > 0 -> println("${ball}볼")
        else -> println("낫싱")
    }
    return false
}

fun newGameSelect(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val restart = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("숫자 입력이 필요합니다.")
    return when (restart) {
        1 -> true
        else -> false
    }
}

fun main() {
    try {
        var continueGame = true
        val computerList = createNum()

        while (continueGame) {
            val playerList = checkNum()
            val isGameEnd = isCorrect(computerList, playerList)
            if (isGameEnd) {
                continueGame = newGameSelect()
                if (continueGame) {
                    main()
                    return
                }
            }
        }
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
