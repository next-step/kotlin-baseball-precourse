import kotlin.random.Random

//1. 컴퓨터가 숫자3개를 생성하는 함수 (중복X, 1~9까지 범위의 수)
public fun createNum(): MutableList<Int> {
    val numList: MutableList<Int> = mutableListOf()

    while (numList.size < 3) {
        val num: Int = Random.nextInt(9)
        if (!numList.contains(num)) {
            numList.add(num)
        }
    }

    return numList
}

//2. 시용자가 숫자3개를 입력하는 함수
fun checkNum(): MutableList<Int> {
    val checkNumList: MutableList<Int> = mutableListOf()
    print("숫자를 입력해 주세요 : ")
    val num: Int = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("잘못된 입력입니다.")

    val hundredDigit = num / 100
    val tenDigit = (num / 10) % 10
    val oneDigit = num % 10

    if (hundredDigit == 0 || tenDigit == 0 || oneDigit == 0) {
        throw IllegalArgumentException("0은 입력할 수 없습니다.")
    }
    if (hundredDigit == tenDigit || hundredDigit == oneDigit || tenDigit == oneDigit) {
        throw IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.")
    }

    checkNumList.add(hundredDigit)
    checkNumList.add(tenDigit)
    checkNumList.add(oneDigit)

    return checkNumList
}


//3.정답인지 아닌지, 볼인지, 스트라이크인지 판별해주는 함수
fun isCorrect (list1: MutableList<Int>, list2 : MutableList<Int>)  {
    var strike = 0
    var ball = 0
    var nothing = false

    for (i in 0..2){
        if (list1[i] == list2[i])
            strike += 1
        else if (list2.contains(list1[i]))
            ball += 1
    }


    if (strike == 0 && ball == 0)
        nothing = true

    if (strike == 3) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        val restart = readLine()?.toIntOrNull()
        when (restart) {
            1 -> newGameSelect()
            2 -> return
            else -> println("잘못된 입력입니다. 게임을 종료합니다.")
        }
    }
    else if (ball >= 1 && strike >=1 )
        println("${ball}볼 ${strike}스트라이크" )
    else if (ball >=1 )
        println("${ball}볼")
    else if (strike >= 1)
        println("${strike}스트라이크")
    else
        println("낫싱")


}

//4.게임을 재시작하는 함수
fun newGameSelect(){
    main()
}

fun main() {
    val computer_list = createNum()
    val player_list = checkNum()

    isCorrect(computer_list,player_list)
    print(computer_list )
    print(player_list)

}

main()