package com.bridgelabz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bridge.labz.CensusAnalyserException;
import com.bridge.labz.CensusAnalyzer;
import org.junit.jupiter.api.Test;

public class IndianStateCensusAnalyserTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH= "E:\\classRoom\\Day_29_Indian_State\\Day_29_Indian_State\\src\\main\\resources\\IndiaStateCensusData.csv";



    public void givenIndianCensusDataCSVFileReturnsCorrectRecords()
    {
        try
        {
            CensusAnalyzer censusAnalyser = new CensusAnalyzer();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            assertEquals(29,numOfRecords);
        }
        catch (CensusAnalyserException e) {
            System.out.println("File not found");
        }
    }
}