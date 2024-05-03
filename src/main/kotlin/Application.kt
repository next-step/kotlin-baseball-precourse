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

//  위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
//  게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
//  이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
//  게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
    fun run():Int{
        while (!win){
            input()
            check()
        }
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return readLine()!!.toInt()
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

//    같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고,
//    그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다. 승리하였다면 win 불린 변수를 참으로 변경한다.
//    컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
    fun check(){
        var ball:Int = 0
        var strike:Int = 0
        var num:Int = answer/100
        if (first == num) strike+=1
        else if (num == second || num == third) ball +=1
        answer %= 100
        num = answer/10
        if (second == num) strike+=1
        else if (num == first || num == third) ball +=1
        answer%=10
        num = answer
        if (third == num) strike+=1
        else if (num == first || num == second) ball +=1

        if (ball + strike == 0) println("낫싱")
        else if (ball == 0){
            println("${strike}스트라이크")
            if (strike == 3){
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                win = true
            }
        }
        else if (strike == 0){
            println("${ball}볼")
        }
        else {
            println("${ball}볼 ${strike}스트라이크")

        }
    }

}




