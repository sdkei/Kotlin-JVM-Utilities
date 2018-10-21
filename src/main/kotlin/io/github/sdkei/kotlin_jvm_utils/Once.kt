package io.github.sdkei.kotlin_jvm_utils

/**
 * Creates a function which can be run only once.
 *
 * The function does nothing except first invocation.
 *
 * At first invocation of the function,
 * it returns a [OnceResult] (not null) which has the result of the invocation of [action].
 * After the second, it returns null.
 *
 * @param action The action you want to do only once.
 */
fun <R> once(action: () -> R): () -> OnceResult<R>? {
    var isDone = false;

    return {
        if (isDone) {
            null
        } else {
            isDone = true

            val result = action()
            OnceResult(result)
        }
    }
}

data class OnceResult<R>(val result: R)