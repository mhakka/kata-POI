package com.mha.poi.utils;

import com.mha.poi.model.POI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class Utils {
    
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Utils.class);

    public static List<POI> getListPOIFromTSVFile(String filePath) throws TechnicalException {
        List<POI> result = new ArrayList<>();
        String line = "";
        String tabulation = "\t";

        BufferedReader br;
        try {
            File tsvfile = new ClassPathResource(filePath).getFile();
            br = new BufferedReader(new FileReader(tsvfile));

            while ((line = br.readLine()) != null) {
                String[] column = line.split(tabulation);
                POI poi = new POI(column[0], Float.valueOf(column[1]), Float.valueOf(column[2]));
                result.add(poi);
            }
        } catch (IOException ex) {
            LOGGER.error("Error when getting data from the file {}", filePath, ex);
            throw new TechnicalException("Error when reading POI's data", ex);
        }
        return result;
    }
    
    public static boolean isFloatValueInTheRange(float value, float minValueInclusive, float maxValueInclusive) {
        return (value >= minValueInclusive && value <= maxValueInclusive);
    }
}
