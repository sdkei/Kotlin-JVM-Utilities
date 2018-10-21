package io.github.sdkei.kotlin_jvm_utils

import org.junit.Assert.assertEquals
import org.junit.Test

class MathUtilsTest {

    @Test
    fun test_modPositive() {
        assertEquals(0, +6 modPositive +3); assertEquals(0, +6 % +3)
        assertEquals(2, +5 modPositive +3); assertEquals(2, +5 % +3)
        assertEquals(1, +4 modPositive +3); assertEquals(1, +4 % +3)
        assertEquals(0, +3 modPositive +3); assertEquals(0, +3 % +3)
        assertEquals(2, +2 modPositive +3); assertEquals(2, +2 % +3)
        assertEquals(1, +1 modPositive +3); assertEquals(1, +1 % +3)
        assertEquals(0, 0 modPositive +3); assertEquals(0, +0 % +3)
        assertEquals(2, -1 modPositive +3); assertEquals(-1, -1 % +3)
        assertEquals(1, -2 modPositive +3); assertEquals(-2, -2 % +3)
        assertEquals(0, -3 modPositive +3); assertEquals(0, -3 % +3)
        assertEquals(2, -4 modPositive +3); assertEquals(-1, -4 % +3)
        assertEquals(1, -5 modPositive +3); assertEquals(-2, -5 % +3)
        assertEquals(0, -6 modPositive +3); assertEquals(0, -6 % +3)

        assertEquals(0, +6 modPositive -3); assertEquals(0, +6 % -3)
        assertEquals(2, +5 modPositive -3); assertEquals(2, +5 % -3)
        assertEquals(1, +4 modPositive -3); assertEquals(1, +4 % -3)
        assertEquals(0, +3 modPositive -3); assertEquals(0, +3 % -3)
        assertEquals(2, +2 modPositive -3); assertEquals(2, +2 % -3)
        assertEquals(1, +1 modPositive -3); assertEquals(1, +1 % -3)
        assertEquals(0, 0 modPositive -3); assertEquals(0, 0 % -3)
        assertEquals(2, -1 modPositive -3); assertEquals(-1, -1 % -3)
        assertEquals(1, -2 modPositive -3); assertEquals(-2, -2 % -3)
        assertEquals(0, -3 modPositive -3); assertEquals(0, -3 % -3)
        assertEquals(2, -4 modPositive -3); assertEquals(-1, -4 % -3)
        assertEquals(1, -5 modPositive -3); assertEquals(-2, -5 % -3)
        assertEquals(0, -6 modPositive -3); assertEquals(0, -6 % -3)
    }
}