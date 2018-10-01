package io.github.sdkei.utilities.property

import kotlin.reflect.KProperty

/**
 * Delegate for property which can be write only once.
 *
 * ```
 * class MyClass {
 *    var myProperty: MyType by WriteOnce()
 * }
 * ```
 */
class WriteOnce<T> {

    private var value: Value<T>? = null

    /**
     * Returns whether the property value is set.
     *
     * ```
     * class MyClass {
     *     private val myPropertyDelegate = WriteOnce<Int>()
     *     var myProperty: Int by myPropertyDelegate
     *     val isMyPropertySet: Boolean
     *         get() = myPropertyDelegate.isSet
     * }
     * ```
     */
    val isSet: Boolean
        get() = value != null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T =
            checkNotNull(value).value

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        check(this.value == null)

        this.value = Value(value)
    }

    private data class Value<T>(
            val value: T
    )
}
