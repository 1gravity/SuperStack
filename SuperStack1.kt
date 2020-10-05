package com.airfox.misc.stack

class MySuperStack1<E: Comparable<E>>: SuperStack<E> {

    private val elements = ArrayList<E>()
    private var minElement: E? = null

    override fun push(x: E) {
        elements.add(x)
        updateMinElement()
    }

    override fun pop(): E? {
        return when(elements.size > 0) {
            true -> elements.removeAt(elements.size - 1).also{ updateMinElement() }
            else -> null
        }
    }

    override fun top(): E? {
        return when(elements.size > 0) {
            true -> elements.elementAt(elements.size - 1)
            else -> null
        }
    }

    override fun getMin() = minElement

    private fun updateMinElement() {
        minElement = null
        for (e in elements) {
            minElement = when {
                minElement == null -> e
                minElement?.compareTo(e) == 1 -> e
                else -> minElement
            }
        }
    }
}
