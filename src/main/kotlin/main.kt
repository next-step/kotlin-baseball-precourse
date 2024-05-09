import kotlin.random.Random

fun main() {
    println("숫자야구 게임 시작")

    while (true) {
        val answer = random()
        val user = userInput()
        val judge = judgement(user, answer)

        if (ExitOrContinue()) continue
        else break
    }
}

fun random(): Array<Int?> { //랜덤 함수: 랜덤으로 숫자 세 개를 생성한다.
    val ranNumber: Array<Int?> = arrayOfNulls<Int>(3)
    val set: HashSet<Int> = HashSet()

    while (set.size < 3) {
        val randomValue = Random.nextInt(1, 10) //1부터 10 중 무작위 뽑기
        set.add(randomValue) //중복된 숫자를 거른다.
    }

    val list: ArrayList<Int> = ArrayList(set) //리스트에 담아주기
    list.shuffle() //섞어주기

    for (i in 0..2) {
        ranNumber[i] = list[i] //리스트에 담아주기
    }

    return ranNumber
}

fun userInput(): Array<Int?> {
    val userNumber: Array<Int?> = arrayOfNulls<Int>(3)
    print("숫자 세 개를 입력해주세요: ")
    val inputNumber: String = readLine() ?: throw IllegalArgumentException("입력이 없습니다.")

    if (inputNumber.length != 3 || !inputNumber.all { it.isDigit() }) {
        throw IllegalArgumentException("다시 입력해주세요.")
    }

    userNumber[0] = inputNumber.substring(0, 1).toInt()
    userNumber[1] = inputNumber.substring(1, 2).toInt()
    userNumber[2] = inputNumber.substring(2, 3).toInt()

    return userNumber
}

fun judgement(inputNumber: Array<Int?>, answerNumber: Array<Int?>): Pair<Int, Int> {
    var strike: Int = 0
    var ball: Int = 0

    inputNumber.forEachIndexed { i, inputNum->
        if (inputNum == answerNumber[i]) {
            strike++
        } else if (inputNum in answerNumber) {
            ball++
        }
    }

    return Pair(strike, ball)
}

fun ExitOrContinue(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    return when (readLine()) {
        "1" -> true
        else -> false
    }
}

fun display(res: Pair<Int, Int>): String {
    val strike = res.first
    val ball = res.second

    if (strike == 0 && ball == 0) return "낫싱"
    else if (strike == 3) return "정답입니다"
    else return "$strike 스트라이크 $ball 볼"
}