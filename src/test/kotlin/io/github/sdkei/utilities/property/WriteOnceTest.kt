package io.github.sdkei.utilities.property

import org.junit.Assert.*
import org.junit.Test

class WriteOnceTest {

    @Test
    fun test_WriteOnce() {
        val myClass = MyClass()

        assertFalse(myClass.isMyPropertySet)
        try {
            myClass.myProperty
            fail()
        } catch (e: IllegalStateException) {
            // OK
        }

        myClass.myProperty = 0
        assertTrue(myClass.isMyPropertySet)
        assertEquals(0, myClass.myProperty)

        try {
            myClass.myProperty = 0
            fail()
        } catch (e: IllegalStateException) {
            // OK
        }
    }

    private class MyClass {
        private val myPropertyDelegate = WriteOnce<Int>()
        var myProperty: Int by myPropertyDelegate
        val isMyPropertySet: Boolean
            get() = myPropertyDelegate.isSet
    }
}