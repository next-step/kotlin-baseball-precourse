fun main(){




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