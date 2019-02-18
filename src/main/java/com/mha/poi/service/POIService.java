package com.mha.poi.service;

import com.mha.poi.model.Area;
import com.mha.poi.model.POI;
import java.util.List;


public interface POIService {
    
    public long getNbrPOIsOfArea(List<POI> inputPOIs, Area area);
    
    public List<Area> getDensestAreas(List<POI> inputPOIs, int limit);
    
}
