
fun main(){

    var retry = true

    while(retry) {
        println("숫자 야구 게임을 시작합니다.")
        println("1에서 9까지 서로 다른 숫자 3개를 생각합니다.")
        var computerNumber = generateComputerNumbers()
        var userNumber : List<Int>?
        var result : String
        do {
            println("(//정답 : $computerNumber)") //정답확인용
            print("맞춰볼 숫자를 입력하시오 : ")
            userNumber = getUserInput()
            result = calculateResult(computerNumber,userNumber)
            println("결과 : $result")

        } while (result != "3 스트라이크")
        println("게임 종료")

        retry = reTry()

    }
    println("게임을 완전히 종료합니다.")
}

//컴퓨터 숫자 생성
fun generateComputerNumbers() : List<Int> {
    return (1..9).shuffled().take(3)
}


//숫자 비교
fun calculateResult(computerNumber : List<Int>, userGuess : List<Int>) : String{

    var strikes = 0
    var balls = 0

    for((index,value) in userGuess.withIndex()){
        if(value == computerNumber[index]){
            strikes++
        }
        else if(value in computerNumber) {
            balls++
        }
    }

    return when{
        strikes == 3 -> "3 스트라이크"
        (strikes > 0 ) && ( balls > 0) -> "$strikes 스트라이크 $balls 볼"
        strikes > 0 -> "$strikes 스트라이크"
        balls > 0 -> "$balls 볼"
        else -> "낫싱"
    }
}

//사용자 입력을 받아서 List형태로 변환
fun getUserInput() : List<Int>{
    print("3자리 숫자를 입력하세요 : ")
    val input = readLine() ?: "" //입력이 null이면 공백 입력
    val inputNumbers = input.map { it.toString().toIntOrNull() }
    validateInput(inputNumbers)
    return inputNumbers.requireNoNulls()
}

//입력값 유효성 판별
fun validateInput(numbers: List<Int?>) {
    if (numbers.size != 3 || numbers.any { it !in 1..9 }) {
        throw IllegalArgumentException("잘못된 입력입니다.")
    }
}

fun reTry() : Boolean {

    var input : String
    do {
        print("다시 하시겠습니까? (y/n) : ")
        input = readLine() ?: ""
    }while (input != "y" && input != "n")

    return input == "y"
}

main()