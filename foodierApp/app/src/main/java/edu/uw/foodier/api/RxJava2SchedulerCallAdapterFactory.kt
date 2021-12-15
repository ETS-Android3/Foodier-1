// This file was created by Jade D'Souza for the Detail Page
// to call the Yelp API to find similar restaurants for the
// given food item, in Washington specifically.
// We used open source code by Yelp in order to navigate their API.
package edu.uw.foodier.api

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.lang.reflect.Type

class RxJava2SchedulerCallAdapterFactory internal constructor(
    okHttpClient: OkHttpClient
) : CallAdapter.Factory() {

    private val subscribeScheduler: Scheduler =
        Schedulers.from(okHttpClient.dispatcher().executorService())
    private val observeScheduler: Scheduler = AndroidSchedulers.mainThread()
    private val wrappedFactory: RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    // overrides the Java RxJava2CallAdapterFactory to return a call adapter
    // with our retrofitted Yelp API
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        val callAdapter = wrappedFactory.get(returnType, annotations, retrofit) ?: return null

        return CallAdapterWrapper(callAdapter)
    }

    private inner class CallAdapterWrapper<R> internal constructor(
        private val wrappedAdapter: CallAdapter<R, *>
    ) : CallAdapter<R, Any> {

        // overrides the responseType function with our adapters
        // response type, or the yelp APIs https response to a
        // Kotlin object
        override fun responseType(): Type {
            return wrappedAdapter.responseType()
        }

        // observes data received from yelp api through a scheduler that refreshes
        // the data
        override fun adapt(call: Call<R>): Any {
            val it: Any = wrappedAdapter.adapt(call)
            return when (it) {
                is Flowable<*> -> it.subscribeOn(subscribeScheduler).observeOn(observeScheduler)
                is Observable<*> -> it.subscribeOn(subscribeScheduler).observeOn(observeScheduler)
                is Single<*> -> it.subscribeOn(subscribeScheduler).observeOn(observeScheduler)
                is Maybe<*> -> it.subscribeOn(subscribeScheduler).observeOn(observeScheduler)
                is Completable -> it.subscribeOn(subscribeScheduler).observeOn(observeScheduler)
                else -> it
            }
        }
    }
}
