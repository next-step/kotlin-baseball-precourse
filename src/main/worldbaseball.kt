fun main(){
    while(true){
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val game = readLine()!!
        if (game == "1"){
            inputUserNumber(createdRandomNumber())

        } else if (game == "2"){
            println("프로그램을 종료합니다.")
            break

        }else{
            throw IllegalArgumentException("A number must be 1 or 2")
        }
    }
}
fun inputUserNumber(randomNumberInFunction : String){
    while(true){
        println("숫자를 입력해 주세요:")
        var userNumberInFunction : String = readLine()!!
        isItPossibleToUse(userNumberInFunction)
        val result = strikeAndBallDecisions(userNumberInFunction,randomNumberInFunction)
        if (result == true){
            break
        }else if (result == false){
            continue
        }

    }
}
fun strikeAndBallDecisions(checkUserNumber: String, checkRandomNumber : String) : Boolean{ //스트라이크 볼 판정
    var ball : Int = 0
    var strike : Int = 0
    for (i in 0..2){
        if(checkUserNumber[i] == checkRandomNumber[i]){
            strike +=1
        }else if (checkUserNumber[i] != checkRandomNumber[i] && checkUserNumber[i] in checkRandomNumber){
            ball +=1
        }else{
            continue
        }

    }

    return  printResult(strike,ball)

}
fun userNumberCheck(numbers : String) : Boolean{
    val numbersList = numbers.toMutableList()
    val checkedNumbersList = numbersList.distinct()
    if (checkedNumbersList.size == 3){
        return true

    }else{
        return false
    }

}
fun isItPossibleToUseUserNumber(userNumberInFunction:String){
    if(userNumberInFunction.length != 3 || userNumberCheck(userNumberInFunction) == false){
        throw IllegalArgumentException("A number must be 100~999 ")
    }
}

fun createdRandomNumber() : String { // 난수 생성 함수
    while(true) {
        val numberRange = (100..999)
        if(withoutOverlapping(numberRange).size == 3){
            return withoutOverlapping(numberRange).joinToString("")}
        else{
            continue
        }
    }

}
fun withoutOverlapping(numberRange: IntRange) : List<Char> {
    val randomNumber = numberRange.random().toString()
    val numberList = randomNumber.toMutableList()
    val checkedNumberList = numberList.distinct()
    return checkedNumberList
}
fun printResult(strike : Int, ball : Int) : Boolean {
    if (strike == 3) {
        println("3스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return true
    } else if (ball == 0 && strike == 0) {
        println("낫싱")
    } else if (ball == 0 && strike != 0) {
        println("${strike}스트라이크")
    } else if (ball != 0 && strike == 0) {
        println("${ball}볼")
    } else {
        println("${ball}볼 ${strike}스트라이크")
    }
    return false

}
