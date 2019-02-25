package com.mha.poi.service;

import com.mha.poi.model.Area;
import java.util.List;

public interface POIService {

    public long getNbrPOIsOfArea(Area area);

    public List<Area> getDensestAreas(int limit);

}
