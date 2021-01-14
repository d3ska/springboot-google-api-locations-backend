package pl.deska.springbootgoogleapilocations.dto;

public class LocationDTO {

    private Double lat;
    private Double lng;
    private String name;

    public LocationDTO(Double lat, Double lon, String name) {
        this.lat = lat;
        this.lng = lon;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LocationDTO{" +
                "lat=" + lat +
                ", lon=" + lng +
                ", name='" + name + '\'' +
                '}';
    }
}
