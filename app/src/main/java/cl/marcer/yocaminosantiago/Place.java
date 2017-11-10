package cl.marcer.yocaminosantiago;

/**
 * Created by ubuntu on 09-11-17.
 */

public class Place {
    private String photoUrl;
    private String name;
    private String duration;
    private String distance;
    private Double lat;
    private Double lng;

    public Place() {
        // Needed for Firebase
    }

    public Place(String photoUrl, String name, String duration, String distance, Double lat, Double lng) {

        this.photoUrl = photoUrl;
        this.name = name;
        this.duration = duration;
        this.distance = distance;
        this.lat = lat;
        this.lng = lng;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
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

}
