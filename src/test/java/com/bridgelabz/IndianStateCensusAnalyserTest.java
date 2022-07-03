package com.bridgelabz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bridge.labz.CensusAnalyserException;
import com.bridge.labz.CensusAnalyzer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IndianStateCensusAnalyserTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH= "E:\\classRoom\\Day_29_Indian_State\\Day_29_Indian_State\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH= "E:\\classRoom\\Day_29_Indian_State\\Day_29_Indian_State\\src\\main\\resources\\IndiaStateCode.csv";


    @Test
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
    @Test
    public void givenIndianCensusDataCSVFile_whenWithWrongPath_shouldThrowException() {
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();

        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try {
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }



    @Test
    public void givenIndianCensusDataCSVFile_whenWithWrongFileType_shouldThrowException() {
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try {
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_TYPE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertNotSame(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
        }
    }

    @Test
    public void givenIndianCensusDataCSVFile_whenWithWrongDelimiters_shouldThrowException()
    {
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        ExpectedException exceptionRule =  ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try


                
        {
            censusAnalyser.loadIndiaCensusData(INVALID_DELIMITER_FILE_PATH);
        }
        catch (CensusAnalyserException e)
        {
            Assertions.assertNotSame(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
        }
    }
}