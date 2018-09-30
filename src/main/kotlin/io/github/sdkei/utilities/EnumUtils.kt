package io.github.sdkei.utilities

//
// Non-extension functions
//


//
// Extension functions
//

/**
 * Returns next [n]-th enum constant.
 *
 * ```
 * Month.FEBRUARY.next(2) // -> Month.APRIL
 * Month.DECEMBER.next(1) // -> null
 * ```
 */
inline fun <reified E : Enum<E>> E.next(n: Int = 1): E? {
    val values = enumValues<E>()
    val nextOrdinal = ordinal + n
    return if (0 <= nextOrdinal && nextOrdinal < values.size) values[nextOrdinal]
    else null
}

/**
 * Returns previous [n]-th enum constant.
 *
 * ```
 * Month.NOVEMBER.prev(2) // -> Month.SEPTEMBER
 * Month.JANUARY.prev(1) // -> null
 * ```
 */
inline fun <reified E : Enum<E>> E.prev(n: Int = 1): E? =
        next(-n)

/**
 * Returns next [n]-th enum constant cyclically.
 *
 * ```
 * Month.FEBRUARY.next(2) // -> Month.APRIL
 * Month.DECEMBER.next(1) // -> Month.JANUARY
 * ```
 */
inline fun <reified E : Enum<E>> E.cyclicNext(n: Int = 1): E {
    val values = enumValues<E>()
    val valuesSize = values.size
    val nextOrdinal = (ordinal + n) modPositive valuesSize
    return values[nextOrdinal]
}

/**
 * Returns previous [n]-th enum constant cyclically.
 *
 * ```
 * Month.NOVEMBER.prev(2) // -> Month.SEPTEMBER
 * Month.JANUARY.prev(1) // -> Month.DECEMBER
 * ```
 */
inline fun <reified E : Enum<E>> E.cyclicPrev(n: Int = 1): E =
        cyclicNext(-n)


//
// Extension properties
//

/**
 * Returns next enum constant.
 *
 * ```
 * Month.FEBRUARY.next // -> Month.MARCH
 * Month.DECEMBER.next // -> null
 * ```
 */
inline val <reified E : Enum<E>> E.next: E?
    get() = next()

/**
 * Returns previous enum constant.
 *
 * ```
 * Month.NOVEMBER.prev // -> Month.OCTOBER
 * Month.JANUARY.prev // -> null
 * ```
 */
inline val <reified E : Enum<E>> E.prev: E?
    get() = prev()

/**
 * Returns next enum constant cyclically.
 *
 * ```
 * Month.FEBRUARY.next // -> Month.MARCH
 * Month.DECEMBER.next // -> Month.JANUARY
 * ```
 */
inline val <reified E : Enum<E>> E.cyclicNext: E
    get() = cyclicNext()

/**
 * Returns previous enum constant cyclically.
 *
 * ```
 * Month.NOVEMBER.prev // -> Month.OCTOBER
 * Month.JANUARY.prev // -> Month.DECEMBER
 * ```
 */
inline val <reified E : Enum<E>> E.cyclicPrev: E
    get() = cyclicPrev()
