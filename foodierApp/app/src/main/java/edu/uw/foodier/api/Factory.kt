// This file was created by Jade D'Souza for the Detail Page
// to call the Yelp API to find similar restaurants for the
// given food item, in Washington specifically.
// We used open source code by Yelp in order to navigate their API.
package edu.uw.foodier.api

interface Factory<T : Any> {
    var mock: T?
    fun instance(): T
}

open class Provider<T : Any>(init: () -> T) : Factory<T> {
    override var mock: T? = null
    private val instance: T by lazy(init)
    override fun instance() = mock ?: instance
}
