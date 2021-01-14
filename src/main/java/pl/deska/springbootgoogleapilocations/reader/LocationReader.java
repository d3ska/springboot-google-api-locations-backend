package pl.deska.springbootgoogleapilocations.reader;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.deska.springbootgoogleapilocations.model.LocationDetails;

@Service
public class LocationReader implements DataReader{

    private static final String URL =
            "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=lat, lon&radius=1500&type=restaurant&key=XXX";

    private RestTemplate restTemplate;

    public LocationReader() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public ResponseEntity getData(String lat, String lon) {
        return restTemplate.exchange(getTransofmedUrl(lat, lon),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                LocationDetails.class);
    }

    private String getTransofmedUrl(String lat, String lon) {
       return URL.replace("lat", lat)
                .replace("lon", lon);
    }
}
