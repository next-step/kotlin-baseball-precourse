//컴퓨터: 1~9 서로 다른 임의의 수 3개 랜덤 생성
fun randomNumber(): List<Int> {
    return (1..9).shuffled().take(3)
}

//플레이어: 3개 숫자 입력
fun playerInput(): List<Int> {
    print("숫자를 입력해 주세요 : ")
    val input = readLine() ?: throw IllegalArgumentException("입력이 없습니다")
    if(input.length != 3 || !input.all {it.isDigit()} || input.toSet().size != 3) {
        throw IllegalArgumentException("1~9까지 서로 다른 수로 이루어진 3자리의 숫자를 입력하세요.")
    }
    return input.map {it.toString().toInt()}
}