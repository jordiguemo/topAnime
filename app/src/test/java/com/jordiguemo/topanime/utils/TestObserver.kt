package com.jordiguemo.topanime.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import org.junit.Assert

class LiveDataTestObserver<T> constructor(
    private val liveData: LiveData<T>
) : Observer<T> {

    init {
        liveData.observeForever(this)
    }

    private val testValues = mutableListOf<T>()

    override fun onChanged(t: T) {
        if (t != null) testValues.add(t)
    }

    fun assertNoValues(): LiveDataTestObserver<T> {
        if (testValues.isNotEmpty()) throw AssertionError(
            "Assertion error with actual size ${testValues.size}"
        )
        return this
    }

    fun assertValueCount(count: Int): LiveDataTestObserver<T> {
        if (count < 0) throw AssertionError(
            "Assertion error! value count cannot be smaller than zero"
        )
        if (count != testValues.size) throw AssertionError(
            "Assertion error! with expected $count while actual ${testValues.size}"
        )
        return this
    }

    fun assertValues(vararg predicates: T): LiveDataTestObserver<T> {
        if (!testValues.containsAll(predicates.asList())) throw AssertionError("Assertion error!")
        return this
    }

    fun assertValues(predicate: (List<T>) -> Boolean): LiveDataTestObserver<T> {
        predicate(testValues)
        return this
    }

    fun values(predicate: (List<T>) -> Unit): LiveDataTestObserver<T> {
        predicate(testValues)
        return this
    }

    fun values(): List<T> {
        return testValues
    }

    fun assertLastValue(t: T){
        return Assert.assertEquals(t, testValues.last())
    }

    /**
     * Removes this observer from the [LiveData] which was observing
     */
    fun dispose() {
        liveData.removeObserver(this)
    }

    /**
     * Clears data available in this observer and removes this observer from the [LiveData] which was observing
     */
    fun clear() {
        testValues.clear()
        dispose()
    }
}

fun <T> LiveData<T>.test(): LiveDataTestObserver<T> {

    val testObserver = LiveDataTestObserver(this)

    // Remove this testObserver that is added in init block of TestObserver, and clears previous data
    testObserver.clear()
    observeForever(testObserver)

    return testObserver
}