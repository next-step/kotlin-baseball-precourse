import kotlin.random.Random

fun main(){
    val answer = setComputer()
    println("Computer : ${answer.joinToString()}")
}

//컴퓨터가 1에서 9까지 서로 다른 임의의 수 3개 선택
fun setComputer() : IntArray{
    val answer = mutableListOf<Int>()
    while (answer.size < 3){
        answer.add(Random.nextInt(1, 10))
    }
    return answer.toIntArray()
}

