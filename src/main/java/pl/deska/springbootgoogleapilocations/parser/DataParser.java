package pl.deska.springbootgoogleapilocations.parser;

import java.util.List;

public interface DataParser<S> {

    List<S> getParsedData(String lat, String lon);
}
