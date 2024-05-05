import java.util.*

val comNumberList = mutableListOf<Int>()
var strike: Int = 0
var ball: Int = 0

fun makeRanNum() { // 컴퓨터가 랜덤한 숫자 3개 생성 후 리스트에 저장
    val random = Random()
    comNumberList.clear()
    while (true) {
        val computerNum = random.nextInt(9) + 1
        if (!comNumberList.contains(computerNum)) {
            comNumberList.add(computerNum)
        }
        if (comNumberList.size > 2) break
    }
}

fun checkStrike(userNumberList: List<Int>): Unit {
    strike = 0
    if (comNumberList[0] == userNumberList[0])
        strike++
    if (comNumberList[1] == userNumberList[1])
        strike++
    if (comNumberList[2] == userNumberList[2])
        strike++
}

fun checkBall(userNumberList: List<Int>): Unit {
    ball = 0
    for (i in comNumberList) {
        if (i == userNumberList[0])
            ball++
        if (i == userNumberList[1])
            ball++
        if (i == userNumberList[2])
            ball++
    }
}

fun checkNothing(): Unit {
    if (strike == 0 && ball == 0) println("낫싱") else {
        println("${ball - strike} 볼 $strike 스트라이크")
    }
}

fun checkList(userNumberList: List<Int>): Unit {
    if (userNumberList.size != 3 || userNumberList.any { it !in 1..9 }) {
        throw IllegalArgumentException("IllegalArgumentException")
    }
}

fun main() {
    makeRanNum()
    println("컴퓨터가 생성한 숫자 : $comNumberList")
    while (true) {
        try {
            print("숫자를 입력해 주세요 : ")
            val input = readLine()
            val userNumberList = input?.map { it.toString().toInt() } ?: listOf()
            checkStrike(userNumberList)
            checkBall(userNumberList)
            checkNothing()
            checkList(userNumberList)
        } catch (exception: IllegalArgumentException) {
            return
        }
        if (strike == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            break
        }
    }
    val reStart = readLine()!!.toInt()
    if (reStart == 1) main()
    if (reStart == 2) return

}


