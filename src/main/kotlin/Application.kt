import kotlin.random.Random

fun main(){
    //val answer = setComputer()
    //println("Computer : ${answer.joinToString()}")
    val guess = getPlayerInput()
    println("Game Player : ${guess.joinToString()}")
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

