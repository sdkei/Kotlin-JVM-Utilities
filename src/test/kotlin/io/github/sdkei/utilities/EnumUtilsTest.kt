package io.github.sdkei.utilities

import org.junit.Assert.assertEquals
import org.junit.Test

import io.github.sdkei.utilities.EnumUtilsTest.PrimaryColor.*

class EnumUtilsTest {

    @Test
    fun test_next() {
        assertEquals(null, RED.next(-2))
        assertEquals(null, RED.next(-1))
        assertEquals(RED, RED.next(0))
        assertEquals(GREEN, RED.next(1))
        assertEquals(BLUE, RED.next(2))
        assertEquals(null, RED.next(3))
        assertEquals(null, RED.next(4))

        assertEquals(null, GREEN.next(-3))
        assertEquals(null, GREEN.next(-2))
        assertEquals(RED, GREEN.next(-1))
        assertEquals(GREEN, GREEN.next(0))
        assertEquals(BLUE, GREEN.next(1))
        assertEquals(null, GREEN.next(2))
        assertEquals(null, GREEN.next(3))

        assertEquals(null, BLUE.next(-4))
        assertEquals(null, BLUE.next(-3))
        assertEquals(RED, BLUE.next(-2))
        assertEquals(GREEN, BLUE.next(-1))
        assertEquals(BLUE, BLUE.next(0))
        assertEquals(null, BLUE.next(1))
        assertEquals(null, BLUE.next(2))
    }

    @Test
    fun test_cyclicNext() {
        assertEquals(GREEN, RED.cyclicNext(-2))
        assertEquals(BLUE, RED.cyclicNext(-1))
        assertEquals(RED, RED.cyclicNext(0))
        assertEquals(GREEN, RED.cyclicNext(1))
        assertEquals(BLUE, RED.cyclicNext(2))
        assertEquals(RED, RED.cyclicNext(3))
        assertEquals(GREEN, RED.cyclicNext(4))

        assertEquals(GREEN, GREEN.cyclicNext(-3))
        assertEquals(BLUE, GREEN.cyclicNext(-2))
        assertEquals(RED, GREEN.cyclicNext(-1))
        assertEquals(GREEN, GREEN.cyclicNext(0))
        assertEquals(BLUE, GREEN.cyclicNext(1))
        assertEquals(RED, GREEN.cyclicNext(2))
        assertEquals(GREEN, GREEN.cyclicNext(3))

        assertEquals(GREEN, BLUE.cyclicNext(-4))
        assertEquals(BLUE, BLUE.cyclicNext(-3))
        assertEquals(RED, BLUE.cyclicNext(-2))
        assertEquals(GREEN, BLUE.cyclicNext(-1))
        assertEquals(BLUE, BLUE.cyclicNext(0))
        assertEquals(RED, BLUE.cyclicNext(1))
        assertEquals(GREEN, BLUE.cyclicNext(2))
    }

    enum class PrimaryColor {
        RED, GREEN, BLUE
    }
}