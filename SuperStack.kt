package com.airfox.misc.stack

interface SuperStack<E: Comparable<E>> {
    /***
     * Push element `x` onto the stack.
     */
    fun push(x: E)

    /**
     * Remove the element on top of the stack
     */
    fun pop(): E?

    /**
     * Get the top element
     */
    fun top(): E?

    /**
     * Get the minimum element in the stack in O(1) time
     */
    fun getMin(): E?
}
