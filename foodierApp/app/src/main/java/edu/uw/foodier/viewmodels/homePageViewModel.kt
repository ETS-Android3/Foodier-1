package edu.uw.foodier.viewmodels
// This file is for the homePage created by Lauren Ng
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.uw.foodier.FoodItem
import edu.uw.foodier.api.GoogleMapAPI
import edu.uw.foodier.models.distanceMaps.DistanceMap
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class homePageViewModel : ViewModel(){

    val LiveFoodItemList: List<FoodItem> = listOf<FoodItem>(FoodItem("bimbimbap","https://s3-media0.fl.yelpcdn.com/bphoto/glQT58yaz5suBRV1nvku6w/o.jpg","Korean Tofu House","4142 Brooklyn Ave NE Seattle, WA 98105"),
        FoodItem("Seafood Pancake","https://st.depositphotos.com/2869437/3739/i/950/depositphotos_37392643-stock-photo-close-up-of-pug.jpg","Korean Tofu House","4142 Brooklyn Ave NE Seattle, WA 98105"),
        FoodItem("tteokbokki","https://solidstarts.com/wp-content/uploads/Potato-for-Babies-scaled.jpg","Korean Tofu House","4142 Brooklyn Ave NE Seattle, WA 98105"),
        FoodItem("Tofu soup","https://s3-media0.fl.yelpcdn.com/bphoto/NGG6-yJADbnJTBbvtwRczw/o.jpg","Korean Tofu House","4142 Brooklyn Ave NE Seattle, WA 98105"),
        FoodItem("Lamb Gyro","https://s3-media0.fl.yelpcdn.com/bphoto/8RDWMYK3OfBH7B4NNgte5w/o.jpg","Aladdin Gyro-Cery","4139 University Way NE Seattle, WA 98105"),
        FoodItem("Aladdin Fries","https://s3-media0.fl.yelpcdn.com/bphoto/W4ZUm8JTnEVjUortFkHSHA/o.jpg","Aladdin Gyro-Cery","4139 University Way NE Seattle, WA 98105"),
        FoodItem("Gyro Platter Special","https://s3-media0.fl.yelpcdn.com/bphoto/1STJHfvgQjHBzCYn6_Ay0A/o.jpg","Aladdin Gyro-Cery","4139 University Way NE Seattle, WA 98105"),
        FoodItem("Spicy Pork Bulgogi Bowl","https://s3-media0.fl.yelpcdn.com/bphoto/y7gK7T0-PCaQjzqa1KFXjA/o.jpg","Bugis","4142 Brooklyn Ave NE Seattle, WA 98105"),
        FoodItem("Mapo Tofu Bowl","https://s3-media0.fl.yelpcdn.com/bphoto/WZc19NPRdmbKVBIzPbg7KA/o.jpg","Bugis","4139 University Way NE Seattle, WA 98105"),
        FoodItem("Chicken and Waffles","https://s3-media0.fl.yelpcdn.com/bphoto/r6z7hR8ax3hMO6Xid1oQ1A/o.jpg","Bugis","4139 University Way NE Seattle, WA 98105"),
        FoodItem("Chicken Vindaloo","https://twosleevers.com/wp-content/uploads/2017/06/TS-Chicken-Vindaloo-Wide.jpg","Chili's South Indian Cuisine","4220 University Way NE Seattle, WA 98105")
    )

    fun getFoodItems() : List<FoodItem> {
        return LiveFoodItemList
    }

    fun getDistanceObject(rawObj : FoodItem) : FoodItem {
        val returnObject = rawObj
        // TODO REPLACE WITH CURRENT LOCATION
        GoogleMapAPI.retrofitService.getDirections("AIzaSyANPyWYgrWTJRaUfd6c6oS-QdE2226dHMo", "Seattle,WA", rawObj.address).enqueue(object:
            Callback<DistanceMap> {
            override fun onResponse(call: Call<DistanceMap>, response: Response<DistanceMap>) {
                val timeDistance =
                    response.body()?.routes?.get(0)?.legs?.get(0)?.duration?.text
                if (timeDistance != null) {
                    returnObject.timeDistance = timeDistance
                }
                Log.d("VIEW MODEL", "fetched data is ${timeDistance}")
            }
            override fun onFailure(call: Call<DistanceMap>, t: Throwable) {
                Log.d("viewModel", call.toString().toString())
                t.message?.let { Log.e("viewModel", it) }
                t.localizedMessage?.let{
                    Log.e("viewModel", it) }
            }
        })

        return returnObject
    }
}