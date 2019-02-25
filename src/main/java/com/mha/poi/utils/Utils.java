package com.mha.poi.utils;

import com.mha.poi.model.POI;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Utils {

    private static final String TABULATION = "\t";

    public static Stream<POI> getListPOIFromTSVFile(String filePath) {
        InputStream is
                = Utils.class.getClassLoader().getResourceAsStream(filePath);
        Stream<String> lines = new BufferedReader(new InputStreamReader(is)).lines();
        return lines.map(row -> {
            String[] column = row.split(TABULATION);
            return new POI(column[0], Float.valueOf(column[1]), Float.valueOf(column[2]));
        });
    }

    public static boolean isFloatValueInTheRange(float value, float minValueInclusive, float maxValueInclusive) {
        return (value >= minValueInclusive && value <= maxValueInclusive);
    }
}
