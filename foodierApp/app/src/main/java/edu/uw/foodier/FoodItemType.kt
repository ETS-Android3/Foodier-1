package edu.uw.foodier

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class FoodItemType() : Parcelable {
    var itemName : String = "Default"
    var food_image : String = "https://cdn-prd.content.metamorphosis.com/wp-content/uploads/sites/2/2020/01/shutterstock_1268241238-2.jpg"
    var restaurant : String = "Default"
    var address : String = "1400 NE Campus Parkway, Seattle, WA, 98195"

    constructor(parcel: Parcel) : this() {
        itemName = parcel.readString().orEmpty()
        food_image = parcel.readString().orEmpty()
        restaurant = parcel.readString().orEmpty()
        address = parcel.readString().orEmpty()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(itemName)
        dest.writeString(food_image)
        dest.writeString(restaurant)
        dest.writeString(address)
    }

    companion object CREATOR : Parcelable.Creator<FoodItemType> {
        override fun createFromParcel(source: Parcel): FoodItemType {
            return FoodItemType(source)
        }

        override fun newArray(size: Int): Array<FoodItemType?> {
            return arrayOfNulls(size)
        }
    }
}