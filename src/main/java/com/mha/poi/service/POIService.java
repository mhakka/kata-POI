package com.mha.poi.service;

import com.mha.poi.model.Area;
import com.mha.poi.utils.TechnicalException;
import java.util.List;


public interface POIService {
    
    public long getNbrPOIsOfArea(Area area) throws TechnicalException;
    
    public List<Area> getDensestAreas(int limit) throws TechnicalException;
    
}
