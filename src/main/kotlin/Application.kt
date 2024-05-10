import kotlin.random.Random

class BaseballGame {
    private var continueGame = true

    fun start() {
        while (continueGame) {
            val answer = setComputer()  //��ǻ�Ͱ� ������ ����
            performPlayerAction(answer)
            continueGame = confirmGameExit()
        }
    }
    //���� ������
    private fun performPlayerAction(answer: IntArray) {
        var continueInput = true
        while (continueInput) {
            //println("Computer : ${answer.joinToString()}")    //�׽�Ʈ�� ���� �ڵ�
            val guess = getPlayerInput()
            val result = compareAnswerGuess(answer, guess)
            continueInput = printResult(result)
        }
    }
    //��ǻ�Ͱ� 1���� 9���� ���� �ٸ� ������ �� 3�� ����
    private fun setComputer(): IntArray {
        val answer = mutableListOf<Int>()
        while (answer.size < 3) {
            answer.add(Random.nextInt(1, 10))
        }
        return answer.toIntArray()
    }
    //���� �÷��̾ 1���� 9���� 3���� ���ڸ� �Է�
    private fun getPlayerInput(): IntArray {
        println("Enter three numbers (without blanks like 123): ")
        val input = readLine()
        val guess = input?.let {
            if (it.length != 3 || !it.all { char -> char.isDigit() })
                throw IllegalArgumentException("Input must be three digits!")
            it.map { char -> char.toString().toInt() }.toIntArray()
        } ?: throw IllegalArgumentException("No input provided!")
        return guess
    }
    //��ǻ�Ͱ� ������ ���ڿ� ���� �÷��̾ �Է��� ���ڸ� ��
    //���� ���� ���� �ڸ��� ������ ��Ʈ����ũ, �ٸ� �ڸ��� ������ ��, ���� ���� ���� ������ ����
    private fun compareAnswerGuess(answer: IntArray, guess: IntArray): String {
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
    //���� ����� ��� (3���� ���ڸ� ��� ������ ���� ��� ����� ��Ʈ�� ����� ��)
    //3���� ���ڸ� ��� ������ ���� ����
    private fun printResult(result: String): Boolean {
        println("Result: $result")
        if (result == "3 strikes") {
            println("You got all 3 numbers right! Game over")
            return false
        } else return true
    }
    //������ ����� �� ������ �ٽ� �����ϰų� ������ ����
    private fun confirmGameExit(): Boolean {
        println("Enter 1 to start a new game or 2 to end the game")
        val input = readLine()?.trim()
        return when (input) {
            "1" -> true
            "2" -> false
            else -> {
                println("Invalid input. Please enter 1 for new game or 2 to exit.")
                confirmGameExit()
            }
        }
    }
}

fun main() {
    val game = BaseballGame()
    game.start()
}