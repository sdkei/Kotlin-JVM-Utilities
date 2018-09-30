package io.github.sdkei.utilities

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
