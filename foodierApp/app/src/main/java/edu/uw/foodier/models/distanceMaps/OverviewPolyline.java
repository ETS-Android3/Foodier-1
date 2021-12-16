
package edu.uw.foodier.models.distanceMaps;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.squareup.moshi.Json;

public class OverviewPolyline implements Parcelable
{

    @Json(name = "points")
    private String points;
    public final static Creator<OverviewPolyline> CREATOR = new Creator<OverviewPolyline>() {


        @SuppressWarnings({
            "unchecked"
        })
        public OverviewPolyline createFromParcel(android.os.Parcel in) {
            return new OverviewPolyline(in);
        }

        public OverviewPolyline[] newArray(int size) {
            return (new OverviewPolyline[size]);
        }

    }
    ;

    protected OverviewPolyline(android.os.Parcel in) {
        this.points = ((String) in.readValue((String.class.getClassLoader())));
    }

    public OverviewPolyline() {
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(OverviewPolyline.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("points");
        sb.append('=');
        sb.append(((this.points == null)?"<null>":this.points));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(points);
    }

    public int describeContents() {
        return  0;
    }

}
