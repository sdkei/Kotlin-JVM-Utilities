package io.github.sdkei.kotlin_jvm_utils

import kotlin.math.PI
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

/**
 * Converts degree to radian.
 *
 * @return radian which is greater or equals than -1.0 * PI and less than 1.0 * PI.
 */
fun Double.degToRad(): Double =
        ((this / 180.0) % 2.0).let {
            if (it > 1.0) it - 2.0
            else if (it <= -1.0) it + 2.0
            else it
        } * PI

/**
 * Converts radian to degree.
 *
 * @return degree which is greater or equals than 0.0 and less than 360.0.
 */
fun Double.radToDeg(): Double =
        (this % (2.0 * PI)).letIf({ it < 0.0 }) {
            it + 2.0 * PI
        } / PI * 180.0