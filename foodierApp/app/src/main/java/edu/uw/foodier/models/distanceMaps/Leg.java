
package edu.uw.foodier.models.distanceMaps;

import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Leg implements Parcelable
{

    @com.squareup.moshi.Json(name = "distance")
    private Distance distance;
    @com.squareup.moshi.Json(name = "duration")
    private Duration duration;
    @com.squareup.moshi.Json(name = "end_address")
    private String endAddress;
    @com.squareup.moshi.Json(name = "end_location")
    private EndLocation endLocation;
    @com.squareup.moshi.Json(name = "start_address")
    private String startAddress;
    @com.squareup.moshi.Json(name = "start_location")
    private StartLocation startLocation;
    @com.squareup.moshi.Json(name = "steps")
    private List<Step> steps = null;
    @com.squareup.moshi.Json(name = "traffic_speed_entry")
    private List<Object> trafficSpeedEntry = null;
    @com.squareup.moshi.Json(name = "via_waypoint")
    private List<Object> viaWaypoint = null;
    public final static Creator<Leg> CREATOR = new Creator<Leg>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Leg createFromParcel(android.os.Parcel in) {
            return new Leg(in);
        }

        public Leg[] newArray(int size) {
            return (new Leg[size]);
        }

    }
    ;

    protected Leg(android.os.Parcel in) {
        this.distance = ((Distance) in.readValue((Distance.class.getClassLoader())));
        this.duration = ((Duration) in.readValue((Duration.class.getClassLoader())));
        this.endAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.endLocation = ((EndLocation) in.readValue((EndLocation.class.getClassLoader())));
        this.startAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.startLocation = ((StartLocation) in.readValue((StartLocation.class.getClassLoader())));
        in.readList(this.steps, (edu.uw.foodier.models.distanceMaps.Step.class.getClassLoader()));
        in.readList(this.trafficSpeedEntry, (java.lang.Object.class.getClassLoader()));
        in.readList(this.viaWaypoint, (java.lang.Object.class.getClassLoader()));
    }

    public Leg() {
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public EndLocation getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(EndLocation endLocation) {
        this.endLocation = endLocation;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public StartLocation getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(StartLocation startLocation) {
        this.startLocation = startLocation;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public List<Object> getTrafficSpeedEntry() {
        return trafficSpeedEntry;
    }

    public void setTrafficSpeedEntry(List<Object> trafficSpeedEntry) {
        this.trafficSpeedEntry = trafficSpeedEntry;
    }

    public List<Object> getViaWaypoint() {
        return viaWaypoint;
    }

    public void setViaWaypoint(List<Object> viaWaypoint) {
        this.viaWaypoint = viaWaypoint;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Leg.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("distance");
        sb.append('=');
        sb.append(((this.distance == null)?"<null>":this.distance));
        sb.append(',');
        sb.append("duration");
        sb.append('=');
        sb.append(((this.duration == null)?"<null>":this.duration));
        sb.append(',');
        sb.append("endAddress");
        sb.append('=');
        sb.append(((this.endAddress == null)?"<null>":this.endAddress));
        sb.append(',');
        sb.append("endLocation");
        sb.append('=');
        sb.append(((this.endLocation == null)?"<null>":this.endLocation));
        sb.append(',');
        sb.append("startAddress");
        sb.append('=');
        sb.append(((this.startAddress == null)?"<null>":this.startAddress));
        sb.append(',');
        sb.append("startLocation");
        sb.append('=');
        sb.append(((this.startLocation == null)?"<null>":this.startLocation));
        sb.append(',');
        sb.append("steps");
        sb.append('=');
        sb.append(((this.steps == null)?"<null>":this.steps));
        sb.append(',');
        sb.append("trafficSpeedEntry");
        sb.append('=');
        sb.append(((this.trafficSpeedEntry == null)?"<null>":this.trafficSpeedEntry));
        sb.append(',');
        sb.append("viaWaypoint");
        sb.append('=');
        sb.append(((this.viaWaypoint == null)?"<null>":this.viaWaypoint));
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
        dest.writeValue(endAddress);
        dest.writeValue(endLocation);
        dest.writeValue(startAddress);
        dest.writeValue(startLocation);
        dest.writeList(steps);
        dest.writeList(trafficSpeedEntry);
        dest.writeList(viaWaypoint);
    }

    public int describeContents() {
        return  0;
    }

}
