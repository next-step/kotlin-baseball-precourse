package com.example.number_baseball_game

import kotlin.random.Random

class random {
    val ranNumber: Array<Int?> = arrayOfNulls<Int>(3)

    fun randomNumber() {
        val set: HashSet<Int> = HashSet()

        while (set.size < 3) {
            val randomValue = Random.nextInt(1, 10)
            set.add(randomValue)
        }

        val list: ArrayList<Int> = ArrayList(set)
        list.shuffle()

        for (index in 0..2) {
            ranNumber[index] = list[index]
        }

        fun getRanNumber(): Array<Int?> {
            return ranNumber
        }
    }
}