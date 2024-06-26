package com.github.elimxim

import kotlin.random.Random

class ArrayShuffler(private val script: SortScript = NoOpSortScript()) {
    fun shuffle(array: IntArray) {
        array.apply {
            val rnd = Random(System.currentTimeMillis())
            for (i in array.size - 1 downTo 1) {
                val j = rnd.nextInt(i + 1)
                array.swap(i, j)
                script.action(Swap(i, j))
            }
        }
    }
}