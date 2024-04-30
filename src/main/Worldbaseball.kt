fun main(){



}

fun baseballGame(checkUserNumber: String, checkRandomNumber : String) { //스트라이크 볼 판정




}

fun startGame(randomNumberInFunction : String){



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