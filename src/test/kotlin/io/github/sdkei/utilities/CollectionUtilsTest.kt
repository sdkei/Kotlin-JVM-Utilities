package io.github.sdkei.utilities

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CollectionUtilsTest {

    @Test
    fun test_cyclicLeftShifted() {
        assertEquals(listOf(3, 0, 1, 2), listOf(0, 1, 2, 3).cyclicLeftShifted(-5))
        assertEquals(listOf(0, 1, 2, 3), listOf(0, 1, 2, 3).cyclicLeftShifted(-4))
        assertEquals(listOf(1, 2, 3, 0), listOf(0, 1, 2, 3).cyclicLeftShifted(-3))
        assertEquals(listOf(2, 3, 0, 1), listOf(0, 1, 2, 3).cyclicLeftShifted(-2))
        assertEquals(listOf(3, 0, 1, 2), listOf(0, 1, 2, 3).cyclicLeftShifted(-1))
        assertEquals(listOf(0, 1, 2, 3), listOf(0, 1, 2, 3).cyclicLeftShifted(0))
        assertEquals(listOf(1, 2, 3, 0), listOf(0, 1, 2, 3).cyclicLeftShifted(1))
        assertEquals(listOf(2, 3, 0, 1), listOf(0, 1, 2, 3).cyclicLeftShifted(2))
        assertEquals(listOf(3, 0, 1, 2), listOf(0, 1, 2, 3).cyclicLeftShifted(3))
        assertEquals(listOf(0, 1, 2, 3), listOf(0, 1, 2, 3).cyclicLeftShifted(4))
        assertEquals(listOf(1, 2, 3, 0), listOf(0, 1, 2, 3).cyclicLeftShifted(5))
    }

    @Test
    fun test_cyclicRightShifted() {
        assertEquals(listOf(1, 2, 3, 0), listOf(0, 1, 2, 3).cyclicRightShifted(-5))
        assertEquals(listOf(0, 1, 2, 3), listOf(0, 1, 2, 3).cyclicRightShifted(-4))
        assertEquals(listOf(3, 0, 1, 2), listOf(0, 1, 2, 3).cyclicRightShifted(-3))
        assertEquals(listOf(2, 3, 0, 1), listOf(0, 1, 2, 3).cyclicRightShifted(-2))
        assertEquals(listOf(1, 2, 3, 0), listOf(0, 1, 2, 3).cyclicRightShifted(-1))
        assertEquals(listOf(0, 1, 2, 3), listOf(0, 1, 2, 3).cyclicRightShifted(0))
        assertEquals(listOf(3, 0, 1, 2), listOf(0, 1, 2, 3).cyclicRightShifted(1))
        assertEquals(listOf(2, 3, 0, 1), listOf(0, 1, 2, 3).cyclicRightShifted(2))
        assertEquals(listOf(1, 2, 3, 0), listOf(0, 1, 2, 3).cyclicRightShifted(3))
        assertEquals(listOf(0, 1, 2, 3), listOf(0, 1, 2, 3).cyclicRightShifted(4))
        assertEquals(listOf(3, 0, 1, 2), listOf(0, 1, 2, 3).cyclicRightShifted(5))
    }

    @Test
    fun test_elementAtRandom() {
        assertEquals(0, listOf(0).elementAtRandom())
        assertTrue(listOf(0, 1).elementAtRandom().let { it == 0 || it == 1 })
    }
}