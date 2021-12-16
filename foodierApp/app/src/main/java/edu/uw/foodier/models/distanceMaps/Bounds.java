
package edu.uw.foodier.models.distanceMaps;
// Created by Lauren for the googleMapsAPI results
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Bounds implements Parcelable
{

    @com.squareup.moshi.Json(name = "northeast")
    private Northeast northeast;
    @com.squareup.moshi.Json(name = "southwest")
    private Southwest southwest;
    public final static Creator<Bounds> CREATOR = new Creator<Bounds>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Bounds createFromParcel(android.os.Parcel in) {
            return new Bounds(in);
        }

        public Bounds[] newArray(int size) {
            return (new Bounds[size]);
        }

    }
    ;

    protected Bounds(android.os.Parcel in) {
        this.northeast = ((Northeast) in.readValue((Northeast.class.getClassLoader())));
        this.southwest = ((Southwest) in.readValue((Southwest.class.getClassLoader())));
    }

    public Bounds() {
    }

    public Northeast getNortheast() {
        return northeast;
    }

    public void setNortheast(Northeast northeast) {
        this.northeast = northeast;
    }

    public Southwest getSouthwest() {
        return southwest;
    }

    public void setSouthwest(Southwest southwest) {
        this.southwest = southwest;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Bounds.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("northeast");
        sb.append('=');
        sb.append(((this.northeast == null)?"<null>":this.northeast));
        sb.append(',');
        sb.append("southwest");
        sb.append('=');
        sb.append(((this.southwest == null)?"<null>":this.southwest));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(northeast);
        dest.writeValue(southwest);
    }

    public int describeContents() {
        return  0;
    }

}
