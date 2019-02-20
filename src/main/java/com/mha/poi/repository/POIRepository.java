package com.mha.poi.repository;

import com.mha.poi.model.POI;
import com.mha.poi.utils.TechnicalException;
import java.util.List;


public interface POIRepository {
    public List<POI> getAllPOIs() throws TechnicalException;
}
