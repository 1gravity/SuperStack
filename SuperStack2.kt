package com.airfox.misc.stack

import java.util.*
import kotlin.NoSuchElementException
import kotlin.collections.ArrayList

class MySuperStack2<E: Comparable<E>>: SuperStack<E> {

    private val elements = ArrayList<E>()
    private val minElements = TreeMap<E, Int>()

    override fun push(x: E) {
        elements.add(x)
        addMinElement(x)
    }

    override fun pop(): E? {
        return when(elements.size > 0) {
            true -> elements.removeAt(elements.size - 1)
                .apply{ removeMinElement(this) }
            else -> null
        }
    }

    override fun top(): E? {
        return when(elements.size > 0) {
            true -> elements.elementAt(elements.size - 1)
            else -> null
        }
    }

    override fun getMin(): E? =
        try {
            minElements.firstKey()
        } catch (e: NoSuchElementException) {
            null
        }

    private fun addMinElement(x: E) {
        when (minElements[x]) {
            null -> minElements[x] = 1
            else -> minElements[x] = (minElements[x] ?: 0) + 1
        }
    }

    private fun removeMinElement(x: E) {
        when (minElements[x]) {
            null, 1 -> minElements.remove(x)
            else -> minElements[x] = (minElements[x] ?: 0) - 1
        }
    }

}
