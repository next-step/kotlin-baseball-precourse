import kotlin.random.Random

var status: Boolean = true //올바른 입력이 되었는 지

fun main() {
    println("숫자야구 게임 시작")
    var answer = random() //랜덤 숫자 생성
//    println(answer.contentToString())

    var continueGame = true //게임을 계속 할 건지
    while (continueGame) {
        status = true
        val user = userInput() //userInput 받기
        val judge = judgement(user, answer)

        if (status == true) { //userInput이 올바르면 계속
            val display = display(judge)
            println(display)
        }


        if (judge.first == 3) { //3스트라이크면 게임 종료여부 묻는다
            continueGame = ExitOrContinue()
            answer = random()
//            println(answer.contentToString())
        }
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
    try {
        print("숫자 세 개를 입력해주세요: ")
        val inputNumber: String = readLine() ?: throw IllegalArgumentException("다시 입력해주세요.")

        validateInput(inputNumber) // 입력 값의 유효성 검사를 별도의 함수로 분리

        userNumber[0] = inputNumber.substring(0, 1).toInt()
        userNumber[1] = inputNumber.substring(1, 2).toInt()
        userNumber[2] = inputNumber.substring(2, 3).toInt()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        status = false
    }

    return userNumber
}

fun validateInput(inputNumber: String) { //input 의 유효성 검사
    if (inputNumber.length != 3 || !inputNumber.all { it.isDigit() }) { //입력이 올바르지 않을 때 (길이 3 x, 숫자 아니거나)
        throw IllegalArgumentException("다시 입력해주세요.")

    }

    val digits = inputNumber.map { it.toString().toInt() } //중복일 때
    if (digits.distinct().size != 3) {
        throw IllegalArgumentException("중복 숫자입니다.")
    }
}


fun judgement(inputNumber: Array<Int?>, answerNumber: Array<Int?>): Pair<Int, Int> {
    var strike: Int = 0
    var ball: Int = 0

    inputNumber.forEachIndexed { i, inputNum->
        if (inputNum == answerNumber[i]) { //위치가 같으면 스트라이크
            strike++
        } else if (inputNum in answerNumber) { //들어만 있으면 볼
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
    val strike = res.first //페어의 첫번째 값 스트라이크
    val ball = res.second //페어의 두번째 값 볼

    if (strike == 0 && ball == 0) return "낫싱"
    else if (strike == 3) return "정답입니다"
    else return "$strike 스트라이크 $ball 볼"
}