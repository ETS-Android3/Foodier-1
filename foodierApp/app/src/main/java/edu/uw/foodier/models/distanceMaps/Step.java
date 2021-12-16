
package edu.uw.foodier.models.distanceMaps;

import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Step implements Parcelable
{

    @com.squareup.moshi.Json(name = "distance")
    private Distance__1 distance;
    @com.squareup.moshi.Json(name = "duration")
    private Duration__1 duration;
    @com.squareup.moshi.Json(name = "end_location")
    private EndLocation__1 endLocation;
    @com.squareup.moshi.Json(name = "html_instructions")
    private String htmlInstructions;
    @com.squareup.moshi.Json(name = "polyline")
    private Polyline polyline;
    @com.squareup.moshi.Json(name = "start_location")
    private StartLocation__1 startLocation;
    @com.squareup.moshi.Json(name = "travel_mode")
    private String travelMode;
    @com.squareup.moshi.Json(name = "maneuver")
    private String maneuver;
    public final static Creator<Step> CREATOR = new Creator<Step>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Step createFromParcel(android.os.Parcel in) {
            return new Step(in);
        }

        public Step[] newArray(int size) {
            return (new Step[size]);
        }

    }
    ;

    protected Step(android.os.Parcel in) {
        this.distance = ((Distance__1) in.readValue((Distance__1.class.getClassLoader())));
        this.duration = ((Duration__1) in.readValue((Duration__1.class.getClassLoader())));
        this.endLocation = ((EndLocation__1) in.readValue((EndLocation__1.class.getClassLoader())));
        this.htmlInstructions = ((String) in.readValue((String.class.getClassLoader())));
        this.polyline = ((Polyline) in.readValue((Polyline.class.getClassLoader())));
        this.startLocation = ((StartLocation__1) in.readValue((StartLocation__1.class.getClassLoader())));
        this.travelMode = ((String) in.readValue((String.class.getClassLoader())));
        this.maneuver = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Step() {
    }

    public Distance__1 getDistance() {
        return distance;
    }

    public void setDistance(Distance__1 distance) {
        this.distance = distance;
    }

    public Duration__1 getDuration() {
        return duration;
    }

    public void setDuration(Duration__1 duration) {
        this.duration = duration;
    }

    public EndLocation__1 getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(EndLocation__1 endLocation) {
        this.endLocation = endLocation;
    }

    public String getHtmlInstructions() {
        return htmlInstructions;
    }

    public void setHtmlInstructions(String htmlInstructions) {
        this.htmlInstructions = htmlInstructions;
    }

    public Polyline getPolyline() {
        return polyline;
    }

    public void setPolyline(Polyline polyline) {
        this.polyline = polyline;
    }

    public StartLocation__1 getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(StartLocation__1 startLocation) {
        this.startLocation = startLocation;
    }

    public String getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

    public String getManeuver() {
        return maneuver;
    }

    public void setManeuver(String maneuver) {
        this.maneuver = maneuver;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Step.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("distance");
        sb.append('=');
        sb.append(((this.distance == null)?"<null>":this.distance));
        sb.append(',');
        sb.append("duration");
        sb.append('=');
        sb.append(((this.duration == null)?"<null>":this.duration));
        sb.append(',');
        sb.append("endLocation");
        sb.append('=');
        sb.append(((this.endLocation == null)?"<null>":this.endLocation));
        sb.append(',');
        sb.append("htmlInstructions");
        sb.append('=');
        sb.append(((this.htmlInstructions == null)?"<null>":this.htmlInstructions));
        sb.append(',');
        sb.append("polyline");
        sb.append('=');
        sb.append(((this.polyline == null)?"<null>":this.polyline));
        sb.append(',');
        sb.append("startLocation");
        sb.append('=');
        sb.append(((this.startLocation == null)?"<null>":this.startLocation));
        sb.append(',');
        sb.append("travelMode");
        sb.append('=');
        sb.append(((this.travelMode == null)?"<null>":this.travelMode));
        sb.append(',');
        sb.append("maneuver");
        sb.append('=');
        sb.append(((this.maneuver == null)?"<null>":this.maneuver));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(distance);
        dest.writeValue(duration);
        dest.writeValue(endLocation);
        dest.writeValue(htmlInstructions);
        dest.writeValue(polyline);
        dest.writeValue(startLocation);
        dest.writeValue(travelMode);
        dest.writeValue(maneuver);
    }

    public int describeContents() {
        return  0;
    }

}
