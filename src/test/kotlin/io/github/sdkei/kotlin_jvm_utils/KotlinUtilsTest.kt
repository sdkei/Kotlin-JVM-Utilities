package io.github.sdkei.kotlin_jvm_utils

import org.junit.Assert.assertEquals
import org.junit.Test

class KotlinUtilsTest {

    @Test
    fun test_not() {
        assertEquals(false, not<Boolean> { it }.invoke(true))
        assertEquals(true, not<Boolean> { it }.invoke(false))
    }

    @Test
    fun test_letIf() {
        assertEquals(0, (-1).letIf({ it < 0 }) { 0 })
        assertEquals(1, 1.letIf({ it < 0 }) { 0 })
    }

    @Test
    fun test_letIfNot() {
        assertEquals(0, (-1).letIfNot({ it >= 0 }) { 0 })
        assertEquals(1, 1.letIfNot({ it >= 0 }) { 0 })
    }
}