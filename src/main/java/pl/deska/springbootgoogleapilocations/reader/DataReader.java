package pl.deska.springbootgoogleapilocations.reader;

import org.springframework.http.ResponseEntity;

public interface DataReader {

    ResponseEntity getData(String lat, String lon);
}
