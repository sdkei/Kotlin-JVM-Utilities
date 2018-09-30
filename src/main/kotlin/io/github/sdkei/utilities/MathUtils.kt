package io.github.sdkei.utilities

import kotlin.math.abs

/**
 * Returns positive reminder.
 *
 * ```
 * -1 modPositive 3 // -> 2 // Note: `-1 % 3` returns -1
 * ```
 */
infix fun Int.modPositive(divisor: Int): Int =
        (this % divisor)
                .letIfNot({ it >= 0 }) { it + abs(divisor) }
