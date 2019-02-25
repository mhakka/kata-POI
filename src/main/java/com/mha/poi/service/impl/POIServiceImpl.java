package com.mha.poi.service.impl;

import com.mha.poi.model.Area;
import com.mha.poi.model.POI;
import com.mha.poi.repository.POIRepository;
import java.util.List;
import com.mha.poi.service.POIService;
import com.mha.poi.utils.Utils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class POIServiceImpl implements POIService {

    @Autowired
    POIRepository POIRepository;

    @Override
    public long getNbrPOIsOfArea(Area area) {
        return POIRepository.getAllPOIs().filter(p -> isThePositionInTheArea(p, area)).count();
    }

    private boolean isThePositionInTheArea(POI position, Area area) {
        return Utils.isFloatValueInTheRange(position.getLatitude(), area.getMinLatitude(), area.getMaxLatitude())
                && Utils.isFloatValueInTheRange(position.getLongitude(), area.getMinLogitude(), area.getMaxLongitude());

    }

    @Override
    public List<Area> getDensestAreas(int limit) {
        List<Area> result = new ArrayList<>();
        POIRepository.getAllPOIs().forEach(poi -> {
            Set<Area> areas = getAreasOfPOI(poi);
            areas.forEach(area -> {
                Area addedArea = result.stream().filter(a -> a.equals(area))
                        .findAny().orElseGet(() -> {
                            result.add(area);
                            return area;
                        });
                addedArea.incrementDensity();
            });
        });

        List<Area> sortedResult = result.stream()
                .sorted(Comparator.comparing(Area::getDensity).reversed())
                .collect(Collectors.toList());
        if (sortedResult.size() <= limit) {
            return sortedResult;
        }
        return sortedResult.subList(0, limit);
    }

    private Set<Area> getAreasOfPOI(POI poi) {
        float lat = poi.getLatitude();
        float log = poi.getLongitude();
        Set<Area> result = new HashSet<>();
        //Case of POI between 4 Areas
        if (lat == roundToHalf(lat) && log == roundToHalf(log)) {
            result.add(new Area(lat, lat + 0.5F, log, +0.5F));
            result.add(new Area(lat, lat - 0.5F, log, +0.5F));
            result.add(new Area(lat, lat + 0.5F, log, -0.5F));
            result.add(new Area(lat, lat - 0.5F, log, -0.5F));
            return result;
        }
        //Case of POI between 2 Areas
        if (lat == roundToHalf(lat) && log != roundToHalf(log)) {
            result.add(new Area(lat, lat + 0.5F, floorToHalf(log), ceilToHalf(log)));
            result.add(new Area(lat, lat - 0.5F, floorToHalf(log), ceilToHalf(log)));
            return result;
        }

        if (lat != roundToHalf(lat) && log == roundToHalf(log)) {
            result.add(new Area(floorToHalf(lat), ceilToHalf(lat), log, +0.5F));
            result.add(new Area(floorToHalf(lat), ceilToHalf(lat), log, -0.5F));
            return result;
        }
        //Case of POI in only one area
        if (lat != roundToHalf(lat) && log != roundToHalf(log)) {
            result.add(new Area(floorToHalf(lat), ceilToHalf(lat), floorToHalf(log), ceilToHalf(log)));
            return result;
        }

        return result;
    }

    private float roundToHalf(float value) {
        return Math.round(value * 2) / 2.0f;
    }

    private float floorToHalf(float value) {
        return (float) (Math.floor(value * 2) / 2.0f);
    }

    private float ceilToHalf(float value) {
        return (float) (Math.ceil(value * 2) / 2.0f);
    }

}
