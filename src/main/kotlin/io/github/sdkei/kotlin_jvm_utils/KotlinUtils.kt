package io.github.sdkei.kotlin_jvm_utils

/**
 * Returns negated function of [predicate].
 *
 * ```
 * not<Boolean> { it }.invoke(true) // -> false
 * ```
 */
inline fun <T> not(crossinline predicate: (T) -> Boolean): (T) -> Boolean =
        { predicate(it).not() }

/**
 * If [predicate] is `true`, returns value of [block].
 * Else returns `this`.
 *
 * An argument of [predicate] and [block] are `this`.
 *
 * ```
 * (-1).howeverIf({ it < 0 }) { 0 } // -> 0
 * 1.howeverIf({ it < 0 }) { 0 } // -> 1
 * ```
 */
inline fun <T> T.howeverIf(predicate: (T) -> Boolean, block: (T) -> T): T =
        if (predicate(this)) block(this)
        else this

/**
 * If [predicate] is `false`, returns value of [block].
 * Else returns `this`.
 *
 * An argument of [predicate] and [block] are `this`.
 *
 * ```
 * (-1).howeverIfNot({ it >= 0 }) { 0 } // -> 0
 * 1.howeverIfNot({ it >= 0 }) { 0 } // -> 1
 * ```
 */
inline fun <T> T.howeverIfNot(crossinline predicate: (T) -> Boolean, block: (T) -> T): T =
        howeverIf(not(predicate), block)
