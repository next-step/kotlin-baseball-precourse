fun main() {
    var gameOver: Boolean = false
    var isSelected: Boolean = false
    var selectedNumList = listOf<Int>()
    var userNum: String? = ""
    var userNumList = listOf<Int>()


    if (isSelected == false) {
        selectedNumList = selectNum()
        isSelected = true
    }
    userNum = inputUserNum()
    userNumList = makeUserNumList(userNum)


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