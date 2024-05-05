//컴퓨터: 1~9 서로 다른 임의의 수 3개 랜덤 생성
fun randomNumber(): List<Int> {
    return (1..9).shuffled().take(3)
}