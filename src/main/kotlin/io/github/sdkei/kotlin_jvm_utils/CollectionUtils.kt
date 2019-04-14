package io.github.sdkei.kotlin_jvm_utils

import java.util.*

/**
 * Returns new list each element is moved its position to left.
 *
 * Overflowed elements are added to other end.
 *
 * ```
 * listOf(0, 1, 2, 3).cyclicLeftShifted(1) // -> [1, 2, 3, 0]
 * listOf(0, 1, 2, 3).cyclicLeftShifted(2) // -> [2, 3, 0, 1]
 *
 * listOf(0, 1, 2, 3).cyclicLeftShifted(-1) // -> [3, 0, 1, 2]
 * ```
 */
fun <T> Collection<T>.cyclicLeftShifted(n: Int): List<T> =
        (n modPositive size).let { drop(it) + take(it) }

/**
 * Returns new list each element is moved its position to right.
 *
 * Overflowed elements are added to other end.
 *
 * ```
 * listOf(0, 1, 2, 3).cyclicRightShifted(1) // -> [3, 0, 1, 2]
 * listOf(0, 1, 2, 3).cyclicRightShifted(2) // -> [2, 3, 0, 1]
 *
 * listOf(0, 1, 2, 3).cyclicRightShifted(-1) // -> [1, 2, 3, 0]
 * ```
 */
fun <T> Collection<T>.cyclicRightShifted(n: Int): List<T> =
        cyclicLeftShifted(-n)

/**
 * Returns an element at random.
 */
fun <T> Collection<T>.elementAtRandom(random: Random? = null): T {
    val index = random?.nextInt(size)
            ?: (Math.random() * size).let { Math.floor(it) }.toInt()
    return elementAt(index)
}

/**
 * Returns all pairs of elements of the receiver.
 *
 * listOf("A", "B", "C").allPairs() // -> [(A, B), (A, C), (B, C)]
 */
fun <T> Iterable<T>.allPairs(): List<Pair<T, T>> {
    val inputList = if (this is List<T>) this else toList()
    val outputList = mutableListOf<Pair<T, T>>()
    inputList.forEachIndexed { leftIndex, left ->
        ((leftIndex + 1) until inputList.size).forEach { rightIndex ->
            outputList += left to inputList[rightIndex]
        }
    }
    return outputList
}

/**
 * Returns all pairs of elements of the receiver.
 *
 * sequenceOf("A", "B", "C").allPairs().toList() // -> [(A, B), (A, C), (B, C)]
 */
fun <T> Sequence<T>.allPairs(): Sequence<Pair<T, T>> = sequence {
    val itr = iterator()
    if (!itr.hasNext()) return@sequence

    val list = mutableListOf<T>()

    val first = itr.next()
    while (itr.hasNext()) {
        val right = itr.next()
        list += right
        yield(first to right)
    }

    list.forEachIndexed { leftIndex, left ->
        ((leftIndex + 1) until list.size).forEach { rightIndex ->
            yield(left to list[rightIndex])
        }
    }
}
