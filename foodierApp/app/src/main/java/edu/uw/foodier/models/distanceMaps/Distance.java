
package edu.uw.foodier.models.distanceMaps;
// Created by Lauren for the googleMapsAPI results
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Distance implements Parcelable
{

    @com.squareup.moshi.Json(name = "text")
    private String text;
    @com.squareup.moshi.Json(name = "value")
    private Integer value;
    public final static Creator<Distance> CREATOR = new Creator<Distance>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Distance createFromParcel(android.os.Parcel in) {
            return new Distance(in);
        }

        public Distance[] newArray(int size) {
            return (new Distance[size]);
        }

    }
    ;

    protected Distance(android.os.Parcel in) {
        this.text = ((String) in.readValue((String.class.getClassLoader())));
        this.value = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Distance() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Distance.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("text");
        sb.append('=');
        sb.append(((this.text == null)?"<null>":this.text));
        sb.append(',');
        sb.append("value");
        sb.append('=');
        sb.append(((this.value == null)?"<null>":this.value));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(text);
        dest.writeValue(value);
    }

    public int describeContents() {
        return  0;
    }

}
