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

}




