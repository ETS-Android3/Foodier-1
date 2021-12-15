// This file was created by Jade D'Souza for the Detail Page
// to call the Yelp API to find similar restaurants for the
// given food item, in Washington specifically.
// We used open source code by Yelp in order to navigate their API.
package edu.uw.foodier.model

// gives the total number of businesses found, and a list of the businesses found
// from API
data class BusinessSearchResponse(val total: Int, val businesses: List<Business>)