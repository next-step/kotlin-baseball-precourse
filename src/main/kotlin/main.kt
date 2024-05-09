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

}

fun judgement() {

}

fun ExitOrContinue() {

}