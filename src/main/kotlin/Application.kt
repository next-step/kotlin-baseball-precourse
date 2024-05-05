fun main() {
    while (true) {
        run()
    }
}

fun checkInt(numbers: String): Boolean { // 숫자인지 확인
    try {
        var numbers = numbers.toInt()
        return true
    } catch(e: IllegalArgumentException) {
        throw  IllegalArgumentException("잘못된 입력입니다. 프로그램을 종료합니다.")
    }
}


fun generateRandomInt(): IntArray { // 서로 다른 수로 구성된 배열 리턴
    val answer = IntArray(3)
    for (i in 0 until 3) {
        var randomNumber: Int
        do {
            randomNumber = (1..9).random() // 1부터 9 사이의 임의의 숫자 생성
        } while (randomNumber in answer) // 이미 사용된 숫자인 경우 다시 생성
        answer[i] = randomNumber
    }
    return answer
}

fun run() { // 숫자야구 실행
    val answer = generateRandomInt()

}

fun playGame() {

}
fun stringToNumberArray(input: String): IntArray {
    val numbers = IntArray(3)
    for (i in 0 until 3) {
        val num = input[i] - '0'
        numbers[i] = num
    }
    return numbers
}

fun checkAnswer(){

}
