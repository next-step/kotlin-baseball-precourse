import java.util.Random

val random = Random()
val numberList = mutableListOf<Int>()

while (true) {
    val computerNum = random.nextInt(9)+1
    if (!numberList.contains(computerNum)) {
        numberList.add(computerNum)
    }
    if (numberList.size > 2) break
}

print(numberList)

