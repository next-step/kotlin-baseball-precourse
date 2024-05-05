import kotlin.random.Random

val length = 3

var is3Str = false
var endCondition = ""
var userInput = ""

var answer = ""
var strike = 0
var ball = 0
var temp = -1
var msg = ""
var option = ""

fun main() {
    answer = makeRandom()
    //println(answer)

    while (true){
        is3Str = false
        endCondition = ""
        strike = 0
        ball = 0

        try {
            print("숫자를 입력해 주세요 : ")
            userInput = readLine()!!
        }
        catch (e : IllegalArgumentException){
            println(e.message)
            break
        }

        if (userInput.length != 3 || !userInput.all { it.isDigit() }){
            println("잘못 입력하셨습니다.")
            continue
        }

        is3Str = evaluate(userInput)
        //println("bechanged : "+is3str)


        if (is3Str) endCondition = theEnd(is3Str) //strike = 3인 상태, 사용자의 입력에 따라 1. 게임재시작 2. 종료
        //println("end_condition : "+ end_condition)

        if (endCondition == "Continue") main()
        if (endCondition=="End") break
    }
}

fun makeRandom():String{
    val nums = (1..9).toList().shuffled().take(3)
    val str = nums.joinToString("")
    return str
}

fun evaluate(user:String):Boolean{
    strike = 0
    ball = 0

    // 숫자만 맞는 경우 - ball
    // 자릿수도 맞는 경우 - strike
    for (idx in 0 until length) {
        ballOrStrike(idx, user)
    }
    if (strike == 3){
        msg = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        println(msg)
        return true
    }
    else if (strike==0 && ball==0) msg = "낫싱"
    else if (strike == 0) msg = ball.toString() + "볼"
    else if (ball == 0) msg = strike.toString() + "스트라이크"
    else msg = ball.toString() + "볼 " + strike.toString() + "스트라이크"

    println(msg)
    return false
}

fun theEnd(is3strike:Boolean):String {
    if (is3strike) {
        option = readLine()!!
        if (option == "1") {
            //main()
            return "Continue"
        } else {
            println("종료합니다.")
            return "End"
        }
    }
    return ""
}

fun ballOrStrike(i:Int, u:String):Unit{
    if (u[i] in answer){
        if (u[i] == answer[i]) strike++
        else ball++
    }
}

main()
