package io.github.sdkei.kotlin_jvm_utils

/**
 * Returns permutation of elements of the receiver.
 *
 * ```
 * listOf("A", "B", "C").permutation(2) // -> [[A, B], [A, C], [B, A], [B, C], [C, A], [C, B]]
 * ```
 *
 * @param count number of elements of permutation.
 */
fun <T> Iterable<T>.permutation(count: Int): List<List<T>> {
    require(count >= 0)

    val inputList = if (this is List<T>) this else toList()
    require(count <= inputList.size)

    return inputList.subPermutation(count)
}

private fun <T> List<T>.subPermutation(count: Int): List<List<T>> {
    if (count == 1) return map { listOf(it) }

    return (0 until size).flatMap { index ->
        val first = listOf(this[index])
        (subList(0, index) + subList(index + 1, size))
                .subPermutation(count - 1)
                .map { first + it }
    }
}

/**
 * Returns combination of elements of the receiver.
 *
 * ```
 * listOf("A", "B", "C", "D").combination(3) // -> [[A, B, C], [A, B, D], [A, C, D], [B, C, D]]
 * ```
 *
 * @param count number of elements of combination.
 */
fun <T> Iterable<T>.combination(count: Int): List<List<T>> {
    require(count >= 0)

    val inputList = if (this is List<T>) this else toList()
    require(count <= inputList.size)

    return inputList.subCombination(count)
}

private fun <T> List<T>.subCombination(count: Int): List<List<T>> {
    if (count == 1) return map { listOf(it) }

    return (0 until size - (count - 1)).flatMap { index ->
        val first = listOf(this[index])
        subList(index + 1, size)
                .subCombination(count - 1)
                .map { first + it }
    }
}
