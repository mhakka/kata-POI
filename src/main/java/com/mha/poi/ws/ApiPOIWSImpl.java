package com.mha.poi.ws;

import com.mha.poi.model.Area;
import com.mha.poi.service.POIService;
import com.mha.poi.utils.TechnicalException;
import com.mha.poi.utils.Utils;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiPOIWSImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiPOIWSImpl.class);

    @Autowired
    POIService POIService;

    @RequestMapping(value = "/poiapi/count", method = GET)
    public long getNbrPOIsOfArea(
            @RequestParam("area_minlat") Float areaMinLat,
            @RequestParam("area_maxlat") Float areaMaxLat,
            @RequestParam("area_minlon") Float areaMinlon,
            @RequestParam("area_maxlon") Float areaMaxLon) throws TechnicalException {

        //Parameters validation 
        if (areaMinLat == null
                || !Utils.isFloatValueInTheRange(areaMinLat, -90, 90)) {
            throw new IllegalArgumentException("Invalid 'areaMinLat' parameter");
        }
        if (areaMaxLat == null
                || !Utils.isFloatValueInTheRange(areaMaxLat, -90, 90)) {
            throw new IllegalArgumentException("Invalid 'areaMaxLat' parameter");
        }
        if (areaMinlon == null
                || !Utils.isFloatValueInTheRange(areaMinlon, -120, 120)) {
            throw new IllegalArgumentException("Invalid 'areaMinlon' parameter");
        }
        if (areaMaxLon == null
                || !Utils.isFloatValueInTheRange(areaMaxLon, -120, 120)) {
            throw new IllegalArgumentException("Invalid 'areaMaxLon' parameter");
        }

        Area area = new Area(areaMinLat, areaMaxLat, areaMinlon, areaMaxLon);
        return POIService.getNbrPOIsOfArea(area);
    }

    @RequestMapping(value = "/poiapi/densestareas", method = GET)
    public List<Area> getDensestAreas(@RequestParam("limit") Integer limit) throws TechnicalException {
        if (limit == null) {
            throw new IllegalArgumentException("The 'limit' parameter must not be empty");
        }
        return POIService.getDensestAreas(limit);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
