package io.github.sdkei.kotlin_jvm_utils.property

import kotlin.reflect.KProperty

/**
 * Returns a delegate which calls specified function [action],
 * before changing the value of the property,
 * with old value and new value of the property as its arguments.
 *
 * ```
 * class MyClass {
 *     var myProperty: String by onChanged("myInitialValue") { oldValue, newValue ->
 *         println("Value of `myProperty` will be changed from $oldValue to $newValue.")
 *     }
 * }
 * ```
 *
 * By using [onChanged] function,
 * you can append a function which is called after changed the value of the property,
 * with old value and new value of the property as its arguments.
 *
 * ```
 * class MyClass {
 *     var myProperty: String by onChanging("myInitialValue") { oldValue, newValue ->
 *         println("Value of `myProperty` will be changed from $oldValue to $newValue.")
 *     } onChanged {
 *         println("Value of `myProperty` was changed from $oldValue to $newValue.")
 *     }
 * }
 * ```

 * @param initialValue initial value of the property.
 * @param action a function which is called before changing the value of the property.
 *
 */
fun <T> onChanging(initialValue: T, action: (oldValue: T, newValue: T) -> Unit): OnChanging<T> =
        OnChanging(initialValue, action)

/**
 * Returns a delegate which calls specified function [action],
 * after changed the value of the property,
 * with old value and new value of the property as its arguments.
 *
 * ```
 * class MyClass {
 *     var myProperty: String by onChanged("myInitialValue") { oldValue, newValue ->
 *         println("Value of `myProperty` will be changed from $oldValue to $newValue.")
 *     }
 * }
 * ```
 *
 * By using [onChanging] function,
 * you can append a function which is called before changing the value of the property,
 * with old value and new value of the property as its arguments,
 *
 * ```
 * class MyClass {
 *     var myProperty: String by onChanged("myInitialValue") {
 *         println("Value of `myProperty` was changed from $oldValue to $newValue.")
 *     } onChanging { oldValue, newValue ->
 *         println("Value of `myProperty` will be changed from $oldValue to $newValue.")
 *     }
 * }
 * ```

 * @param initialValue initial value of the property.
 * @param action a function which is called after changed the value of the property.
 *
 */
fun <T> onChanged(initialValue: T, action: (oldValue: T, newValue: T) -> Unit): OnChanged<T> =
        OnChanged(initialValue, action)

abstract class AbstractOnChangingOnChanged<T>(
        initialValue: T
) {
    protected var value: T = initialValue
        private set

    protected abstract val onChanging: ((T, T) -> Unit)?
    protected abstract val onChanged: ((T, T) -> Unit)?

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T =
            value

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        if (this.value == value) return

        val oldValue = this.value
        val newValue = value

        onChanging?.let { it(oldValue, newValue) }
        this.value = value
        onChanged?.let { it(oldValue, newValue) }
    }
}

class OnChanging<T>(
        initialValue: T,
        override val onChanging: (T, T) -> Unit
) : AbstractOnChangingOnChanged<T>(initialValue) {
    override val onChanged = null

    /**
     * Appends a function which is called after changed the value of the property
     * with old value and new value of the property as its arguments.
     */
    infix fun onChanged(action: (T, T) -> Unit): OnChangingOnChanged<T> =
            OnChangingOnChanged(value, onChanging, action)
}

class OnChanged<T>(
        initialValue: T,
        override val onChanged: (T, T) -> Unit
) : AbstractOnChangingOnChanged<T>(initialValue) {
    override val onChanging = null

    /**
     * Appends a function which is called before changing the value of the property
     * with old value and new value of the property as its arguments.
     */
    infix fun onChanging(action: (T, T) -> Unit): OnChangingOnChanged<T> =
            OnChangingOnChanged(value, action, onChanged)
}

class OnChangingOnChanged<T>(
        initialValue: T,
        override val onChanging: (T, T) -> Unit,
        override val onChanged: (T, T) -> Unit
) : AbstractOnChangingOnChanged<T>(initialValue)
