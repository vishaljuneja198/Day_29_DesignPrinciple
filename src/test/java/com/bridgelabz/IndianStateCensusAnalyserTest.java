package com.bridgelabz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bridge.labz.CensusAnalyserException;
import com.bridge.labz.CensusAnalyzer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IndianStateCensusAnalyserTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH= "E:\\classRoom\\Day_29_Indian_State\\Day_29_Indian_State\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH= "E:\\classRoom\\Day_29_Indian_State\\Day_29_Indian_State\\src\\main\\resources\\IndiaStateCode.csv";


    private static final String WRONG_CSV_FILE_TYPE_PATH = "E:\\classRoom\\Day_29_Indian_State\\Day_29_Indian_State\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String INVALID_DELIMITER_FILE_PATH =  "E:\\classRoom\\Day_29_Indian_State\\Day_29_Indian_State\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String INVALID_HEADER_FILE_PATH =  "E:\\classRoom\\Day_29_Indian_State\\Day_29_Indian_State\\src\\main\\resources\\IndiaStateCensusData.csv";

    private static final String INDIA_STATE_CODE_CSV_FILE_PATH = "E:\\classRoom\\Day_29_Indian_State\\Day_29_Indian_State\\src\\main\\resources\\IndiaStateCensusData.csv";

    @Test
    public void givenIndianCensusDataCSVFileReturnsCorrectRecords() {
        try {
            CensusAnalyzer censusAnalyser = new CensusAnalyzer();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29, numOfRecords);
        } catch (CensusAnalyserException e) {
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
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }


    @Test
    public void givenIndianCensusDataCSVFile_whenWithWrongFileType_shouldThrowException()
    {
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        ExpectedException exceptionRule =  ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try
        {
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_TYPE_PATH);
        }
        catch (CensusAnalyserException e)
        {
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
            Assert.assertNotSame(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
        }
    }



    @Test
    public void givenIndianCensusDataCSVFile_whenWithWrongHeaders_shouldThrowException()
    {
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try
        {
            censusAnalyser.loadIndiaCensusData(INVALID_HEADER_FILE_PATH);
        }
        catch (CensusAnalyserException e)
        {
            Assert.assertNotSame(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
        }
    }

    @Test
    public void givenIndiaStateCodeCSVFileReturnsCorrectRecords()
    {
        try
        {
            CensusAnalyzer censusAnalyser = new CensusAnalyzer();
            int numOfRecords = censusAnalyser.loadIndiaStateCode(INDIA_STATE_CODE_CSV_FILE_PATH);
            Assert.assertEquals(37,numOfRecords);
        }
        catch (CensusAnalyserException e) { }
    }
}

