
package edu.uw.foodier.models.distanceMaps;

import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;

public class DistanceMap implements Parcelable
{

    @com.squareup.moshi.Json(name = "geocoded_waypoints")
    private List<GeocodedWaypoint> geocodedWaypoints = null;
    @com.squareup.moshi.Json(name = "routes")
    private List<Route> routes = null;
    @com.squareup.moshi.Json(name = "status")
    private String status;
    public final static Creator<DistanceMap> CREATOR = new Creator<DistanceMap>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DistanceMap createFromParcel(android.os.Parcel in) {
            return new DistanceMap(in);
        }

        public DistanceMap[] newArray(int size) {
            return (new DistanceMap[size]);
        }

    }
    ;

    protected DistanceMap(android.os.Parcel in) {
        in.readList(this.geocodedWaypoints, (edu.uw.foodier.models.distanceMaps.GeocodedWaypoint.class.getClassLoader()));
        in.readList(this.routes, (edu.uw.foodier.models.distanceMaps.Route.class.getClassLoader()));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DistanceMap() {
    }

    public List<GeocodedWaypoint> getGeocodedWaypoints() {
        return geocodedWaypoints;
    }

    public void setGeocodedWaypoints(List<GeocodedWaypoint> geocodedWaypoints) {
        this.geocodedWaypoints = geocodedWaypoints;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DistanceMap.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("geocodedWaypoints");
        sb.append('=');
        sb.append(((this.geocodedWaypoints == null)?"<null>":this.geocodedWaypoints));
        sb.append(',');
        sb.append("routes");
        sb.append('=');
        sb.append(((this.routes == null)?"<null>":this.routes));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(geocodedWaypoints);
        dest.writeList(routes);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
