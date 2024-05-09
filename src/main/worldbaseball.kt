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