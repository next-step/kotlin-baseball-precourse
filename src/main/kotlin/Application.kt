import kotlin.random.Random

fun main(){
    var continueGame = true
    val answer = setComputer()
    println("Computer : ${answer.joinToString()}")

    while(continueGame){
        val guess = getPlayerInput()
        println("Game Player : ${guess.joinToString()}")
        val result = compareAnswerGuess(answer,guess)
    }

}

//��ǻ�Ͱ� 1���� 9���� ���� �ٸ� ������ �� 3�� ����
fun setComputer() : IntArray{
    val answer = mutableListOf<Int>()
    while (answer.size < 3){
        answer.add(Random.nextInt(1, 10))
    }
    return answer.toIntArray()
}

//���� �÷��̾ 1���� 9���� 3���� ���ڸ� �Է�
fun getPlayerInput(): IntArray {
    println("Enter three numbers (without blanks like 123): ")
    val input = readLine()
    val guess = input?.let {
        if (it.length != 3 || !it.all { char -> char.isDigit() })
            throw IllegalArgumentException("Input must be three digits!")
        it.map { char -> char.toString().toInt() }.toIntArray()
    } ?: throw IllegalArgumentException("No input provided!")
    return guess
}

//��ǻ�Ͱ� �����ϰ� �ִ� ���ڿ� ���� �÷��̾ �Է��� ���ڸ� ��
fun compareAnswerGuess(answer: IntArray, guess: IntArray): String {
    var strikes = 0
    var balls = 0

    for (i in answer.indices) {
        if (answer[i] == guess[i]) {
            strikes++
        } else if (answer.contains(guess[i])) {
            balls++
        }
    }

    return when {
        strikes == 3 -> "3 strikes"
        strikes > 0 && balls > 0 -> "$strikes strike, $balls ball"
        strikes > 0 -> "$strikes strike"
        balls > 0 -> "$balls ball"
        else -> "nothing"
    }
}