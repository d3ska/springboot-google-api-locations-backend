package pl.deska.springbootgoogleapilocations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.deska.springbootgoogleapilocations.dto.LocationDTO;
import pl.deska.springbootgoogleapilocations.parser.DataParser;
import java.util.List;


@RestController
public class LocationController {

    private DataParser dataParser;

    @Autowired
    public LocationController(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    @GetMapping("/{lat}/{lon}")
    public LocationDTO[] home(@PathVariable String lat, @PathVariable String lon) {
        List<LocationDTO> result = dataParser.getParsedData(lat, lon);
        return result.toArray(new LocationDTO[result.size()]);
    }


}
