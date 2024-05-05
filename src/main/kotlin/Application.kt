fun main() {
    var gameOver: Boolean = false
    var isSelected: Boolean = false
    var selectedNumList = listOf<Int>()
    var userNum: String? = ""
    var userNumList = listOf<Int>()
    var isMatched: Boolean = false

    while (gameOver == false) {

        if (isSelected == false) {
            selectedNumList = selectNum()
            isSelected = true
        }
        userNum = inputUserNum()
        userNumList = makeUserNumList(userNum)

        isMatched = checkMatch(selectedNumList, userNumList)

        if (isMatched && askEndGame()) {
            gameOver = true // gameOver
        } else if (isMatched) {
            isSelected = false // restart
        }
    }
}

fun selectNum(): List<Int> {
    val numList = mutableListOf<Int>()
    var num: Int = 0
    val range = 1..9  // 1 <= n <= 15

    while (numList.size < 3) {
        num = range.random()
        if (!numList.contains(num)) {
            numList.add(num)
        }
    }
    return numList
}

fun inputUserNum(): String? {
    var userNum: String? = ""

    print("숫자를 입력해 주세요 : ")
    userNum = readlnOrNull()

    return userNum
}

fun makeUserNumList(str: String?): List<Int> {
    val numList = mutableListOf<Int>()
    var num: Int = 0

    for ((index, value) in str!!.withIndex()) {
        num = Character.getNumericValue(value) // 이부분 에러처리하기!
        numList.add(num)
    }
    return numList
}

fun checkMatch(selectedNumList: List<Int>, userNumList: List<Int>): Boolean {
    var ballCnt: Int = 0
    var strikeCnt: Int = 0
    var idx: Int = 0

    //println(selectedNumList)

    for ((userIndex, userValue) in userNumList.withIndex()) {
        idx = selectedNumList.indexOf(userValue)
        if (idx == userIndex) {
            strikeCnt++
        } else if (idx > -1) {
            ballCnt++
        }
    }

    printMatchList(ballCnt, strikeCnt)

    if (strikeCnt == 3) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return true
    } else {
        return false
    }
}

fun printMatchList(ballCnt: Int, strikeCnt: Int) {
    if (ballCnt == 0 && strikeCnt == 0) {
        print("낫싱")
    } else {
        if (ballCnt != 0) {
            print("${ballCnt}볼 ")
        }
        if (strikeCnt != 0) {
            print("${strikeCnt}스트라이크")
        }
    }
    println()
}

fun askEndGame(): Boolean {
    var answer: String? = ""
    var num: Int = 0

    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    answer = readlnOrNull()

    num = Character.getNumericValue(answer!![0]) // 이부분 에러처리하기!

    if (num == 2 || num == -1) {
        return true
    } else {
        return false
    }
}