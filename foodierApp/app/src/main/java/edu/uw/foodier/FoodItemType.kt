package edu.uw.foodier
// Created by Lauren to have a parcelable object for the details page
import android.os.Parcel
import android.os.Parcelable

class FoodItemType() : Parcelable {
    var itemName : String = "Default"
    var foodImage : String = "https://cdn-prd.content.metamorphosis.com/wp-content/uploads/sites/2/2020/01/shutterstock_1268241238-2.jpg"
    var restaurant : String = "Default"
    var address : String = "1400 NE Campus Parkway, Seattle, WA, 98195"

    // constructing this package
    constructor(parcel: Parcel) : this() {
        itemName = parcel.readString().orEmpty()
        foodImage = parcel.readString().orEmpty()
        restaurant = parcel.readString().orEmpty()
        address = parcel.readString().orEmpty()
    }

    // describing the contents, but currently, it just returns 0
    override fun describeContents(): Int {
        return 0
    }

    // writing to the Parcel
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(itemName)
        dest.writeString(foodImage)
        dest.writeString(restaurant)
        dest.writeString(address)
    }

    // creating a parcel either with no data or with some
    companion object CREATOR : Parcelable.Creator<FoodItemType> {
        override fun createFromParcel(source: Parcel): FoodItemType {
            return FoodItemType(source)
        }

        override fun newArray(size: Int): Array<FoodItemType?> {
            return arrayOfNulls(size)
        }
    }
}