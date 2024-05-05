//import java.util.Random
import java.util.*

val random = Random()
val comNumberList = mutableListOf<Int>()


fun plusNumbers(first_num: Int, second_num: Int): Int {
    val result: Int = first_num + second_num
    return result
}

fun makeRanNum() {
    while (true) {
        val computerNum = random.nextInt(9) + 1
        if (!comNumberList.contains(computerNum)) {
            comNumberList.add(computerNum)
        }
        if (comNumberList.size > 2) break
    }
}
// 컴퓨터가 랜덤한 숫자 3개 생성 후 리스트에 저장
var strike: Int = 0
var ball: Int = 0
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

//print(numberList)
fun main() {
    makeRanNum()
    println("컴퓨터가 생성한 숫자 : $comNumberList")

    print("숫자를 입력해 주세요 : ")
    val input = readLine()
    var userNumberList = input?.map { it.toString().toInt() } ?: listOf()
    checkStrike(userNumberList)
    checkBall(userNumberList)
    println("${ball- strike} 볼 $strike 스트라이크 입니다.")
}

main()

