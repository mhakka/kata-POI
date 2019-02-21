package com.mha.poi.utils;

import com.mha.poi.model.POI;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.slf4j.LoggerFactory;

public class Utils {
    
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Utils.class);
    private static final String TABULATION = "\t";

    public static Stream<POI> getListPOIFromTSVFile(String filePath) throws TechnicalException {
        try {
            Path path = Paths.get(ClassLoader.getSystemResource(filePath).toURI());
            return Files.lines(path).map(row -> {
                String[] column = row.split(TABULATION);
                return new POI(column[0], Float.valueOf(column[1]), Float.valueOf(column[2]));
            });
        } catch (IOException | URISyntaxException ex) {
            LOGGER.error("Error when getting data from the file {}", filePath, ex);
            throw new TechnicalException("Error when reading POI's data", ex);
        }
    }
    
    public static boolean isFloatValueInTheRange(float value, float minValueInclusive, float maxValueInclusive) {
        return (value >= minValueInclusive && value <= maxValueInclusive);
    }
}
