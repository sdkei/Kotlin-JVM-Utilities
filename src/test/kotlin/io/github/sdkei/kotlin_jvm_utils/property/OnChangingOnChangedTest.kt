package io.github.sdkei.kotlin_jvm_utils.property

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class OnChangingOnChangedTest {

    @Test
    fun test_onChanging() {
        val log = mutableListOf<String>()
        lateinit var getCurrentValue: () -> Int
        val obj = object {
            var myProperty by onChanging(0) { oldValue, newValue ->
                log += "onChanging $oldValue -> $newValue"
                log += "currentValue: ${getCurrentValue()}"
            }
        }
        getCurrentValue = { obj.myProperty }

        obj.myProperty = 1
        assertEquals(
                listOf(
                        "onChanging 0 -> 1",
                        "currentValue: 0"
                ),
                log
        )

        log.clear()
        obj.myProperty = 1
        assertTrue(log.isEmpty())
    }

    @Test
    fun test_onChanged() {
        val log = mutableListOf<String>()
        lateinit var getCurrentValue: () -> Int
        val obj = object {
            var myProperty by onChanged(0) { oldValue, newValue ->
                log += "onChanged $oldValue -> $newValue"
                log += "currentValue: ${getCurrentValue()}"
            }
        }
        getCurrentValue = { obj.myProperty }

        obj.myProperty = 1
        assertEquals(
                listOf(
                        "onChanged 0 -> 1",
                        "currentValue: 1"
                ),
                log
        )

        log.clear()
        obj.myProperty = 1
        assertTrue(log.isEmpty())
    }

    @Test
    fun test_onChanging_onChanged() {
        val log = mutableListOf<String>()
        lateinit var getCurrentValue: () -> Int
        val obj = object {
            var myProperty by onChanging(0) { oldValue, newValue ->
                log += "onChanging $oldValue -> $newValue"
                log += "currentValue: ${getCurrentValue()}"
            } onChanged { oldValue, newValue ->
                log += "onChanged $oldValue -> $newValue"
                log += "currentValue: ${getCurrentValue()}"
            }
        }
        getCurrentValue = { obj.myProperty }

        obj.myProperty = 1
        assertEquals(
                listOf(
                        "onChanging 0 -> 1",
                        "currentValue: 0",
                        "onChanged 0 -> 1",
                        "currentValue: 1"
                ),
                log
        )

        log.clear()
        obj.myProperty = 1
        assertTrue(log.isEmpty())
    }

    @Test
    fun test_onChanged_onChanging() {
        val log = mutableListOf<String>()
        lateinit var getCurrentValue: () -> Int
        val obj = object {
            var myProperty by onChanged(0) { oldValue, newValue ->
                log += "onChanged $oldValue -> $newValue"
                log += "currentValue: ${getCurrentValue()}"
            } onChanging { oldValue, newValue ->
                log += "onChanging $oldValue -> $newValue"
                log += "currentValue: ${getCurrentValue()}"
            }
        }
        getCurrentValue = { obj.myProperty }

        obj.myProperty = 1
        assertEquals(
                listOf(
                        "onChanging 0 -> 1",
                        "currentValue: 0",
                        "onChanged 0 -> 1",
                        "currentValue: 1"
                ),
                log
        )

        log.clear()
        obj.myProperty = 1
        assertTrue(log.isEmpty())
    }
}