fun main() {
    while(true){
        run()
    }
}
fun run() {
    val answer = generateRandomInt()
    while(true){
        try {
            playGame(answer)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            break
        }
    }
}
fun generateRandomInt(): IntArray { // 서로 다른 수로 구성된 배열 리턴
    val answer = IntArray(3)
    for (i in 0 until 3) {
        answer[i] = getUniqueNumber(answer)
    }
    return answer
}
fun getUniqueNumber(answer: IntArray): Int { // 1부터 9 사이의 중복되지 않은 난수 생성
    var number : Int
    do {
        number = (1..9).random()
    } while (number in answer)
    return number
}
fun playGame(answer: IntArray) { // 숫자야구 실행한다
    val userInput = getUserInput()
    ballOrStrikeOrOut(userInput, answer) // 볼 스트라이크 아웃 확인
}
fun getUserInput(): IntArray {
    print("숫자를 입력해 주세요: ")
    val input = readLine() ?: throw IllegalArgumentException("잘못된 입력입니다. 프로그램을 종료합니다.")
    checkInputLength(input) // 길이 3인지
    checkInputIsNumeric(input) // 숫자인지
    checkInputDuplicate(input) // 중복 없는지
    return stringToNumberArray(input) // 검사 통과하면 유저 배열을 반환
}
fun checkInputLength(input: String) {
    if (input.length != 3) {
        throw IllegalArgumentException("세 자리가 아닙니다. 프로그램을 종료합니다.")
    }
}
fun checkInputIsNumeric(input: String) {
    if (!input.all { it.isDigit() }) {
        throw IllegalArgumentException("숫자가 아닙니다. 프로그램을 종료합니다.")
    }
}
fun checkInputDuplicate(input: String) {
    val distinctNumbers = input.toSet() // set으로 변환해 중복 제거
    if (distinctNumbers.size != 3) {
        throw IllegalArgumentException("중복된 숫자가 있습니다. 프로그램을 종료합니다.")
    }
}
fun stringToNumberArray(input: String): IntArray {
    val numbers = IntArray(3)
    for (i in 0 until 3) {
        val num = input[i] - '0'
        numbers[i] = num
    }
    return numbers
}
fun ballOrStrikeOrOut(userInput: IntArray, answer: IntArray){
    var strike: Int = 0
    var ball: Int = 0

    for(i in 0 until 3){
        var CurrentStrike = strike(userInput[i], answer[i])
        strike += CurrentStrike
        ball +=  ball(userInput[i], answer, CurrentStrike)
    }
    getResult(strike, ball)
    checkCorrectAnswer(strike)
}
fun ball(userNumber: Int, answer: IntArray, strike: Int): Int {
    if (userNumber in answer && strike == 0) return 1 else return 0
}
fun strike(userNumber: Int, answerNumber: Int): Int{
    if(userNumber==answerNumber) return 1 else return 0
}

fun getResult(strike: Int, ball: Int){
    var result: String = ""
    if(ball != 0){
        result += "$ball 볼"
    }else if(strike != 0){
        result += "$result$strike 스트라이크"
    }else result+="낫싱"
    println(result)
}

fun checkCorrectAnswer(strike: Int){
    if(strike==3){
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val input = readLine() ?: throw IllegalArgumentException("잘못된 입력입니다. 프로그램을 종료합니다.")
        restartOrExit(input)
    }
}
fun restartOrExit(userInput: String){
    val input = userInput.toInt() ?:throw IllegalArgumentException("잘못된 입력입니다. 프로그램을 종료합니다.")
    if(input==1){
        // 새로 시작하기
    }else if(input==2){
        // 완전 종료하기
    }else throw IllegalArgumentException("잘못된 입력입니다. 프로그램을 종료합니다.")
}
