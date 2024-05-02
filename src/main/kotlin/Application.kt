import kotlin.random.Random
import java.io.BufferedReader


fun generateGoalNumber(): String {
    var number = mutableSetOf<Int>()

    while (number.size < 3){
        val randomNumber = Random.nextInt(1,10)
        number.add(randomNumber)
    }
    return number.joinToString("")
}

fun checkInputNumber(number: String){
    //세 자리 숫자인지 확인
    if (number.length != 3){
        throw IllegalArgumentException("세 자리 숫자를 입력해주세요")
    }
    // 각 자리 숫자가 1~9인지 확인
    number.forEach{
        if (it !in '1'..'9'){
            throw IllegalArgumentException("각 자리의 숫자는 1~9사이 입니다")
        }
    }
}

fun compareNumber(){}

fun main(){
    
}