package com.mha.poi.repository;

import com.mha.poi.model.POI;
import com.mha.poi.utils.TechnicalException;
import java.util.stream.Stream;


public interface POIRepository {
    public Stream<POI> getAllPOIs() throws TechnicalException;
}
