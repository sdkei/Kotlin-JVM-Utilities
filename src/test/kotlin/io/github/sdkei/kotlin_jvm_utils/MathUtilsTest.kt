package io.github.sdkei.kotlin_jvm_utils

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.PI

class MathUtilsTest {

    @Test
    fun test_Int_modPositive() {
        assertEquals(0, +6 modPositive +3); assertEquals(+0, +6 % +3)
        assertEquals(2, +5 modPositive +3); assertEquals(+2, +5 % +3)
        assertEquals(1, +4 modPositive +3); assertEquals(+1, +4 % +3)
        assertEquals(0, +3 modPositive +3); assertEquals(+0, +3 % +3)
        assertEquals(2, +2 modPositive +3); assertEquals(+2, +2 % +3)
        assertEquals(1, +1 modPositive +3); assertEquals(+1, +1 % +3)
        assertEquals(0, +0 modPositive +3); assertEquals(+0, +0 % +3)
        assertEquals(2, -1 modPositive +3); assertEquals(-1, -1 % +3)
        assertEquals(1, -2 modPositive +3); assertEquals(-2, -2 % +3)
        assertEquals(0, -3 modPositive +3); assertEquals(+0, -3 % +3)
        assertEquals(2, -4 modPositive +3); assertEquals(-1, -4 % +3)
        assertEquals(1, -5 modPositive +3); assertEquals(-2, -5 % +3)
        assertEquals(0, -6 modPositive +3); assertEquals(+0, -6 % +3)

        assertEquals(0, +6 modPositive -3); assertEquals(+0, +6 % -3)
        assertEquals(2, +5 modPositive -3); assertEquals(+2, +5 % -3)
        assertEquals(1, +4 modPositive -3); assertEquals(+1, +4 % -3)
        assertEquals(0, +3 modPositive -3); assertEquals(+0, +3 % -3)
        assertEquals(2, +2 modPositive -3); assertEquals(+2, +2 % -3)
        assertEquals(1, +1 modPositive -3); assertEquals(+1, +1 % -3)
        assertEquals(0, +0 modPositive -3); assertEquals(+0, +0 % -3)
        assertEquals(2, -1 modPositive -3); assertEquals(-1, -1 % -3)
        assertEquals(1, -2 modPositive -3); assertEquals(-2, -2 % -3)
        assertEquals(0, -3 modPositive -3); assertEquals(+0, -3 % -3)
        assertEquals(2, -4 modPositive -3); assertEquals(-1, -4 % -3)
        assertEquals(1, -5 modPositive -3); assertEquals(-2, -5 % -3)
        assertEquals(0, -6 modPositive -3); assertEquals(+0, -6 % -3)
    }

    @Test
    fun test_Double_modPositive() {
        val delta = 0.0

        assertEquals(0.0, +6.0 modPositive +3.0, delta); assertEquals(+0.0, +6.0 % +3.0, delta)
        assertEquals(2.0, +5.0 modPositive +3.0, delta); assertEquals(+2.0, +5.0 % +3.0, delta)
        assertEquals(1.0, +4.0 modPositive +3.0, delta); assertEquals(+1.0, +4.0 % +3.0, delta)
        assertEquals(0.0, +3.0 modPositive +3.0, delta); assertEquals(+0.0, +3.0 % +3.0, delta)
        assertEquals(2.0, +2.0 modPositive +3.0, delta); assertEquals(+2.0, +2.0 % +3.0, delta)
        assertEquals(1.0, +1.0 modPositive +3.0, delta); assertEquals(+1.0, +1.0 % +3.0, delta)
        assertEquals(0.0, +0.0 modPositive +3.0, delta); assertEquals(+0.0, +0.0 % +3.0, delta)
        assertEquals(2.0, -1.0 modPositive +3.0, delta); assertEquals(-1.0, -1.0 % +3.0, delta)
        assertEquals(1.0, -2.0 modPositive +3.0, delta); assertEquals(-2.0, -2.0 % +3.0, delta)
        assertEquals(0.0, -3.0 modPositive +3.0, delta); assertEquals(+0.0, -3.0 % +3.0, delta)
        assertEquals(2.0, -4.0 modPositive +3.0, delta); assertEquals(-1.0, -4.0 % +3.0, delta)
        assertEquals(1.0, -5.0 modPositive +3.0, delta); assertEquals(-2.0, -5.0 % +3.0, delta)
        assertEquals(0.0, -6.0 modPositive +3.0, delta); assertEquals(+0.0, -6.0 % +3.0, delta)

        assertEquals(0.0, +6.0 modPositive -3.0, delta); assertEquals(+0.0, +6.0 % -3.0, delta)
        assertEquals(2.0, +5.0 modPositive -3.0, delta); assertEquals(+2.0, +5.0 % -3.0, delta)
        assertEquals(1.0, +4.0 modPositive -3.0, delta); assertEquals(+1.0, +4.0 % -3.0, delta)
        assertEquals(0.0, +3.0 modPositive -3.0, delta); assertEquals(+0.0, +3.0 % -3.0, delta)
        assertEquals(2.0, +2.0 modPositive -3.0, delta); assertEquals(+2.0, +2.0 % -3.0, delta)
        assertEquals(1.0, +1.0 modPositive -3.0, delta); assertEquals(+1.0, +1.0 % -3.0, delta)
        assertEquals(0.0, +0.0 modPositive -3.0, delta); assertEquals(+0.0, +0.0 % -3.0, delta)
        assertEquals(2.0, -1.0 modPositive -3.0, delta); assertEquals(-1.0, -1.0 % -3.0, delta)
        assertEquals(1.0, -2.0 modPositive -3.0, delta); assertEquals(-2.0, -2.0 % -3.0, delta)
        assertEquals(0.0, -3.0 modPositive -3.0, delta); assertEquals(+0.0, -3.0 % -3.0, delta)
        assertEquals(2.0, -4.0 modPositive -3.0, delta); assertEquals(-1.0, -4.0 % -3.0, delta)
        assertEquals(1.0, -5.0 modPositive -3.0, delta); assertEquals(-2.0, -5.0 % -3.0, delta)
        assertEquals(0.0, -6.0 modPositive -3.0, delta); assertEquals(+0.0, -6.0 % -3.0, delta)
    }

    @Test
    fun test_degToRad() {
        val delta = 1.0 / 0x1000000
        assertEquals(-0.5 * PI, (-450.0).degToRad(), delta)
        assertEquals(+0.0 * PI, (-360.0).degToRad(), delta)
        assertEquals(+0.5 * PI, (-270.0).degToRad(), delta)
        assertEquals(+1.0 * PI, (-180.0).degToRad(), delta)
        assertEquals(-0.5 * PI, (-90.0).degToRad(), delta)
        assertEquals(+0.0 * PI, (-0.0).degToRad(), delta)
        assertEquals(+0.0 * PI, 0.0.degToRad(), delta)
        assertEquals(+0.5 * PI, 90.0.degToRad(), delta)
        assertEquals(+1.0 * PI, 180.0.degToRad(), delta)
        assertEquals(-0.5 * PI, 270.0.degToRad(), delta)
        assertEquals(+0.0 * PI, 360.0.degToRad(), delta)
        assertEquals(+0.5 * PI, 450.0.degToRad(), delta)
    }

    @Test
    fun test_radToDeg() {
        val delta = 1.0 / 0x1000000
        assertEquals(270.0, (-2.5 * PI).radToDeg(), delta)
        assertEquals(0.0, (-2.0 * PI).radToDeg(), delta)
        assertEquals(90.0, (-1.5 * PI).radToDeg(), delta)
        assertEquals(180.0, (-1.0 * PI).radToDeg(), delta)
        assertEquals(270.0, (-0.5 * PI).radToDeg(), delta)
        assertEquals(0.0, (-0.0 * PI).radToDeg(), delta)
        assertEquals(0.0, (+0.0 * PI).radToDeg(), delta)
        assertEquals(90.0, (+0.5 * PI).radToDeg(), delta)
        assertEquals(180.0, (+1.0 * PI).radToDeg(), delta)
        assertEquals(270.0, (+1.5 * PI).radToDeg(), delta)
        assertEquals(0.0, (+2.0 * PI).radToDeg(), delta)
        assertEquals(90.0, (+2.5 * PI).radToDeg(), delta)
    }
}