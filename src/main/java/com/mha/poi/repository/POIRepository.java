package com.mha.poi.repository;

import com.mha.poi.model.POI;
import java.util.stream.Stream;

public interface POIRepository {

    public Stream<POI> getAllPOIs();
}
