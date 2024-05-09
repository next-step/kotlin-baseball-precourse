import kotlin.random.Random

fun main() {

}

fun random() { //랜덤 함수: 랜덤으로 숫자 세 개를 생성한다.
    val ranNumber: Array<Int?> = arrayOfNulls<Int>(3)
    val set: HashSet<Int> = HashSet()

    while (set.size < 3) {
        val randomValue = Random.nextInt(1, 10) //1부터 10 중 무작위 뽑기
        set.add(randomValue) //중복된 숫자를 거른다.
    }

    val list: ArrayList<Int> = ArrayList(set) //리스트에 담아주기
    list.shuffle() //섞어주기

    for (i in 0..2) {
        ranNumber[i] = list[i] //리스트에 담아주기
    }
}

fun userInput() {
    val userNumber: Array<Int?> = arrayOfNulls<Int>(3)
    print("숫자 세 개를 입력해주세요: ")
    val inputNumber: String = readLine() ?: throw IllegalArgumentException("입력이 없습니다.")

    if (inputNumber.length != 3 || !inputNumber.all { it.isDigit() }) {
        throw IllegalArgumentException("다시 입력해주세요.")
    }

    userNumber[0] = inputNumber.substring(0, 1).toInt()
    userNumber[1] = inputNumber.substring(1, 2).toInt()
    userNumber[2] = inputNumber.substring(2, 3).toInt()
}

fun judgement() {

}

fun ExitOrContinue() {

}