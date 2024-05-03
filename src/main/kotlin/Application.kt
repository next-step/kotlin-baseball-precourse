import java.lang.IllegalArgumentException

class Computer{
    val RANGE = (1..9)
    var first:Int
    var second:Int
    var third:Int
    var answer:Int = 0
    var win:Boolean = false
//    컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
    init {
        first = RANGE.random()
        do {
            second = RANGE.random()
        } while (first == second)
        do {
            third = RANGE.random()
        } while (first == third || second == third)

    }

//    게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력.
//    범위를 벗어나거나 Int가 아닐 경우 에러 발생.
    fun input(){
        print("숫자를 입력해 주세요 : ")
        answer = readLine()!!.toInt()
        if (answer>999 || answer <100){
//            println("IllegalArgumentException 잘못된 값을 입력하셨습니다.")
            error("error")
        }


    }

}




