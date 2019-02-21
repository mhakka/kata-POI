package com.mha.poi.repository.impl;

import com.mha.poi.model.POI;
import com.mha.poi.repository.POIRepository;
import com.mha.poi.utils.Utils;
import com.mha.poi.utils.TechnicalException;
import java.util.stream.Stream;
import org.springframework.stereotype.Repository;

@Repository
public class POIRepositoryImpl implements POIRepository{
    
    private static final String POI_FILE= "poi.tsv";
    
    @Override
    public Stream<POI> getAllPOIs() throws TechnicalException{
        return Utils.getListPOIFromTSVFile(POI_FILE);
    }
    
}
