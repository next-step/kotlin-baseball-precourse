fun main() {
    while(true){
        run()
    }
}
fun run() {
    while(true){
        try {
            playGame()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            break
        }
    }
}
fun generateRandomInt(): IntArray { // 서로 다른 수로 구성된 배열 리턴
    val answer = IntArray(3)
    for (i in 0 until 3) {
        var randomNumber = getUniqueNumber(answer)
        answer[i] = randomNumber
    }
    return answer
}
fun getUniqueNumber(answer: IntArray): Int {
    var number : Int
    do {
        number = (1..9).random() // 1부터 9 사이의 임의의 숫자 생성
    } while (number in answer)
    return number
}
fun playGame() { // 숫자야구 실행한다
    val answer = generateRandomInt()
    while(true){
        val userInput = getUserInput()
        println(userInput.joinToString { "" })
    }
}
fun getUserInput(): IntArray {
    print("숫자를 입력해 주세요: ")
    val input = readLine() ?: throw IllegalArgumentException("잘못된 입력입니다.")
    checkInputLength(input)
    checkInputIsNumeric(input)
    checkInputDuplicate(input)
    return stringToNumberArray(input) // 검사 통과하면 유저 배열을 반환한다
}
fun checkInputLength(input: String) {
    if (input.length != 3) {
        throw IllegalArgumentException("세 자리가 아닙니다.")
    }
}
fun checkInputIsNumeric(input: String) {
    if (!input.all { it.isDigit() }) {
        throw IllegalArgumentException("숫자가 아닙니다.")
    }
}
fun checkInputDuplicate(input: String) {
    val distinctNumbers = input.toSet() // set으로 변환해 중복 제거
    if (distinctNumbers.size != 3) {
        throw IllegalArgumentException("중복된 숫자가 있습니다.")
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
fun checkAnswer(){

}
