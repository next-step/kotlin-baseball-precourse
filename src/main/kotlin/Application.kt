import kotlin.random.Random

fun main(){
    var continueGame = true

    while(continueGame){
        val answer = setComputer()  //��ǻ���� ����
        //println("Computer : ${answer.joinToString()}")
        performPlayerAction(answer)
        continueGame = confirmGameExit()
    }

}

fun performPlayerAction(answer: IntArray){
    var continueInput = true
    while(continueInput){
        println("Computer : ${answer.joinToString()}")
        val guess = getPlayerInput()    //���� �÷��̾ �Է��� ����
        println("Game Player : ${guess.joinToString()}")
        val result = compareAnswerGuess(answer,guess)   //���� �÷��̾ �Է��� ���ڿ� ��ǻ�Ͱ� ������ ���ڸ� ��
        continueInput = printResult(result)
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
//���� ���� ���� �ڸ��� ������ ��Ʈ����ũ, �ٸ� �ڸ��� ������ ��, ���� ���� ���� ������ ����
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

//���� ����� ��� (3���� ���ڸ� ��� ������ ���� ��� ����� ��Ʈ�� ����� ��)
//3���� ���ڸ� ��� ������ ���� ����
fun printResult(result: String):Boolean{
    println("Result: $result")
    if (result == "3 strikes"){
        println("You got all 3 numbers right! Game over")
        return false
    } else return true
}

//������ ������ �� ������ �ٽ� �����ϰų� ������ ����
fun confirmGameExit():Boolean{
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
