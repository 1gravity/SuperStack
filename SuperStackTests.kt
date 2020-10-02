package com.airfox.misc.stack

import junit.framework.Assert.assertEquals
import org.junit.Test

class SuperStackTests {

    @Test
    fun basicStackTests() {
        val stack = MySuperStack<Int>()
        stack.push(2)
        stack.push(3)
        stack.push(1)
        assertEquals(1, stack.top())
        stack.pop()
        assertEquals(3, stack.top())
        stack.pop()
        assertEquals(2, stack.top())
        stack.pop()
        assertEquals(null, stack.top())
    }

    @Test
    fun minTests() {
        val stack = MySuperStack<Int>()
        stack.push(2)
        assertEquals(2, stack.getMin())
        stack.push(3)
        assertEquals(2, stack.getMin())
        stack.push(1)
        assertEquals(1, stack.getMin())
        stack.pop()
        assertEquals(2, stack.getMin())
        stack.push(2)
        assertEquals(2, stack.getMin())
        stack.push(0)
        assertEquals(0, stack.getMin())
        stack.push(2)
        assertEquals(0, stack.getMin())
        stack.pop()
        assertEquals(0, stack.getMin())
        stack.push(1)
        assertEquals(0, stack.getMin())
        stack.pop()
        assertEquals(0, stack.getMin())
        stack.pop()
        assertEquals(2, stack.getMin())
    }

    @Test
    fun edgeCasesTests() {
        val stack = MySuperStack<Int>()
        assertEquals(null, stack.top())
        assertEquals(null, stack.pop())
        assertEquals(null, stack.getMin())
        stack.push(2)
        assertEquals(2, stack.top())
        assertEquals(2, stack.pop())
        assertEquals(null, stack.getMin())
        stack.push(2)
        assertEquals(2, stack.getMin())
        stack.push(2)
        assertEquals(2, stack.getMin())
        stack.push(3)
        assertEquals(2, stack.getMin())
        stack.pop()
        stack.pop()
        assertEquals(2, stack.getMin())
        stack.pop()
        assertEquals(null, stack.getMin())
        stack.pop()
        assertEquals(null, stack.getMin())
    }

}
