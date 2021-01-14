package pl.deska.springbootgoogleapilocations.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.deska.springbootgoogleapilocations.dto.LocationDTO;
import pl.deska.springbootgoogleapilocations.model.LocationDetails;
import pl.deska.springbootgoogleapilocations.model.Result;
import pl.deska.springbootgoogleapilocations.reader.DataReader;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationParser implements DataParser<LocationDTO> {

    private DataReader dataReader;

    @Autowired
    public LocationParser(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    @Override
    public List<LocationDTO> getParsedData(String lat, String lon){
        ResponseEntity<LocationDetails> data = dataReader.getData(lat, lon);
        return  parseData(data.getBody());
    }

    private List<LocationDTO> parseData(LocationDetails locationDetails) {
        return  locationDetails
                .getResults()
                .stream()
                .map(this::converToDto)
                .collect(Collectors.toList());
    }

    private LocationDTO converToDto(Result result) {
            Double lat = result.getGeometry().getLocation().getLat();
            Double lon = result.getGeometry().getLocation().getLng();
            String name = result.getName();
            return new LocationDTO(lat, lon, name);
    }


}
