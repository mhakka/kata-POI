package com.mha.poi.repository.impl;

import com.mha.poi.model.POI;
import com.mha.poi.repository.POIRepository;
import com.mha.poi.utils.Utils;
import java.util.stream.Stream;
import org.springframework.stereotype.Repository;

@Repository
public class POIRepositoryImpl implements POIRepository {

    private static final String POI_FILE = "poi.tsv";

    @Override
    public Stream<POI> getAllPOIs() {
        return Utils.getListPOIFromTSVFile(POI_FILE);
    }

}
