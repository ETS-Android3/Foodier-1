package edu.uw.foodier.model

import io.reactivex.Single
import edu.uw.foodier.Factory
import edu.uw.foodier.Provider
import edu.uw.foodier.api

open class BusinessRepo {
    companion object : Factory<BusinessRepo> by Provider({ BusinessRepo() })

    open fun search(term: String): Single<BusinessSearchResponse> {
        return api<BusinessSearch>().search(term)
    }
}