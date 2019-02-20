package com.mha.poi.service.impl;

import com.mha.poi.model.Area;
import com.mha.poi.model.POI;
import com.mha.poi.repository.impl.POIRepositoryImpl;
import com.mha.poi.utils.TechnicalException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class POIServiceImplTest {
    
    @Mock
    private POIRepositoryImpl POIRepositoryMock;
    
    @InjectMocks
    private POIServiceImpl POIServiceImpl;
    
    @Before
    public void setUp() throws TechnicalException {
        List<POI> inputPOIs = new ArrayList<>();
        inputPOIs.add(new POI("id1", -37.7F, -48.6F));
        inputPOIs.add(new POI("id2", 8.4F, -27.1F));
        inputPOIs.add(new POI("id3", -6.9F,  6.6F));
        inputPOIs.add(new POI("id4", 38.3F,  -2.3F));
        inputPOIs.add(new POI("id5", -6.9F,  6.8F));
        inputPOIs.add(new POI("id6", 38.3F,  -2.5F));
        inputPOIs.add(new POI("id7", -0.1F,  0.1F));
        inputPOIs.add(new POI("id8", 38.1F,  -2.1F));
        
        Mockito.when(POIRepositoryMock.getAllPOIs()).thenReturn(inputPOIs);
    }

    /**
     * Test of getNbrPOIsOfArea method, of class POIServiceImpl.
     * @throws com.mha.poi.utils.TechnicalException
     */
    @Test
    public void testGetNbrPOIsOfArea() throws TechnicalException {
        //Given
        Area area = new Area(6.5F, 7F, -7F, -6.5F);       
        
        //when
        long result = POIServiceImpl.getNbrPOIsOfArea(area);
        
        //Then
        assertEquals(2L, result);
    }

    /**
     * Test of getDensestArea method, of class POIServiceImpl.
     * @throws com.mha.poi.utils.TechnicalException
     */
    @Test
    public void testGetDensestAreas() throws TechnicalException {
        //Given
        Area area1 = new Area(-2.5F, -2F, 38F, 38.5F);
        Area area2 = new Area(6.5F, 7F, -7F, -6.5F);
        
        //When
        List<Area> result = POIServiceImpl.getDensestAreas(2);
        
        //Then
        assertEquals(2, result.size());
        assertEquals(area1, result.get(0));
        assertEquals(area2, result.get(1));
    }
    
}
