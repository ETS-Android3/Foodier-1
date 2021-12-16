
package edu.uw.foodier.models.distanceMaps;

import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Route implements Parcelable
{

    @com.squareup.moshi.Json(name = "bounds")
    private Bounds bounds;
    @com.squareup.moshi.Json(name = "copyrights")
    private String copyrights;
    @com.squareup.moshi.Json(name = "legs")
    private List<Leg> legs = null;
    @com.squareup.moshi.Json(name = "overview_polyline")
    private OverviewPolyline overviewPolyline;
    @com.squareup.moshi.Json(name = "summary")
    private String summary;
    @com.squareup.moshi.Json(name = "warnings")
    private List<Object> warnings = null;
    @com.squareup.moshi.Json(name = "waypoint_order")
    private List<Object> waypointOrder = null;
    public final static Creator<Route> CREATOR = new Creator<Route>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Route createFromParcel(android.os.Parcel in) {
            return new Route(in);
        }

        public Route[] newArray(int size) {
            return (new Route[size]);
        }

    }
    ;

    protected Route(android.os.Parcel in) {
        this.bounds = ((Bounds) in.readValue((Bounds.class.getClassLoader())));
        this.copyrights = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.legs, (edu.uw.foodier.models.distanceMaps.Leg.class.getClassLoader()));
        this.overviewPolyline = ((OverviewPolyline) in.readValue((OverviewPolyline.class.getClassLoader())));
        this.summary = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.warnings, (java.lang.Object.class.getClassLoader()));
        in.readList(this.waypointOrder, (java.lang.Object.class.getClassLoader()));
    }

    public Route() {
    }

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    public OverviewPolyline getOverviewPolyline() {
        return overviewPolyline;
    }

    public void setOverviewPolyline(OverviewPolyline overviewPolyline) {
        this.overviewPolyline = overviewPolyline;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Object> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<Object> warnings) {
        this.warnings = warnings;
    }

    public List<Object> getWaypointOrder() {
        return waypointOrder;
    }

    public void setWaypointOrder(List<Object> waypointOrder) {
        this.waypointOrder = waypointOrder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Route.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("bounds");
        sb.append('=');
        sb.append(((this.bounds == null)?"<null>":this.bounds));
        sb.append(',');
        sb.append("copyrights");
        sb.append('=');
        sb.append(((this.copyrights == null)?"<null>":this.copyrights));
        sb.append(',');
        sb.append("legs");
        sb.append('=');
        sb.append(((this.legs == null)?"<null>":this.legs));
        sb.append(',');
        sb.append("overviewPolyline");
        sb.append('=');
        sb.append(((this.overviewPolyline == null)?"<null>":this.overviewPolyline));
        sb.append(',');
        sb.append("summary");
        sb.append('=');
        sb.append(((this.summary == null)?"<null>":this.summary));
        sb.append(',');
        sb.append("warnings");
        sb.append('=');
        sb.append(((this.warnings == null)?"<null>":this.warnings));
        sb.append(',');
        sb.append("waypointOrder");
        sb.append('=');
        sb.append(((this.waypointOrder == null)?"<null>":this.waypointOrder));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(bounds);
        dest.writeValue(copyrights);
        dest.writeList(legs);
        dest.writeValue(overviewPolyline);
        dest.writeValue(summary);
        dest.writeList(warnings);
        dest.writeList(waypointOrder);
    }

    public int describeContents() {
        return  0;
    }

}
