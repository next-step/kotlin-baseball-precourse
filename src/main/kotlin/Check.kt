fun check(userInput: List<Int>, computerNumbers: List<Int>): Result {
    if (userInput.size != computerNumbers.size) {
        throw IllegalArgumentException("입력된 숫자의 개수가 일치하지 않습니다.")
    }

    var strikes = 0
    var balls = 0

    for ((index, number) in userInput.withIndex()) {
        if (number == computerNumbers[index]) {
            strikes++
        } else if (number in computerNumbers) {
            balls++
        }
    }

    return Result(strikes, balls)
}
