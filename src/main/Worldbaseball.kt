fun main() {
    while(true){
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val game = readLine()!!
        if (game == "1"){
            startGame(createdRandomNumber())

        } else if (game == "2"){
            println("프로그램을 종료합니다.")
            break

        }else{
            throw IllegalArgumentException("A number must be 1 or 2")
        }
    }
}

fun baseballGame(checkUserNumber: String, checkRandomNumber : String) { //스트라이크 볼 판정




}

fun startGame(randomNumberInFunction : String){
    while(true){
        println("숫자를 입력해 주세요:")
        var userNumberInFunction : String = readLine()!!
        if(randomNumberInFunction == userNumberInFunction){
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            break
        }else if(userNumberInFunction.length != 3){
            throw IllegalArgumentException("A number must be 100~999 ")
            break
        }else{
            baseballGame(userNumberInFunction,randomNumberInFunction)
        }
    }
}

fun createdRandomNumber() : String { // 랜덤 난수 생성 함수!
    while(true) {
        val numberRange = (100..999)
        val randomNumber = numberRange.random().toString()
        val numberList = randomNumber.toMutableList()
        val checkedNumberList = numberList.distinct()
        if(checkedNumberList.size == 3){ // 숫자 없애기
            return checkedNumberList.joinToString("")}
        else{
            continue
        }
    }

}