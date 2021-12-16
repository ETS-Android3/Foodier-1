
package edu.uw.foodier.models.distanceMaps;

import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EndLocation__1 implements Parcelable
{

    @com.squareup.moshi.Json(name = "lat")
    private Double lat;
    @com.squareup.moshi.Json(name = "lng")
    private Double lng;
    public final static Creator<EndLocation__1> CREATOR = new Creator<EndLocation__1>() {


        @SuppressWarnings({
            "unchecked"
        })
        public EndLocation__1 createFromParcel(android.os.Parcel in) {
            return new EndLocation__1(in);
        }

        public EndLocation__1 [] newArray(int size) {
            return (new EndLocation__1[size]);
        }

    }
    ;

    protected EndLocation__1(android.os.Parcel in) {
        this.lat = ((Double) in.readValue((Double.class.getClassLoader())));
        this.lng = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    public EndLocation__1() {
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EndLocation__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lat");
        sb.append('=');
        sb.append(((this.lat == null)?"<null>":this.lat));
        sb.append(',');
        sb.append("lng");
        sb.append('=');
        sb.append(((this.lng == null)?"<null>":this.lng));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(lat);
        dest.writeValue(lng);
    }

    public int describeContents() {
        return  0;
    }

}
