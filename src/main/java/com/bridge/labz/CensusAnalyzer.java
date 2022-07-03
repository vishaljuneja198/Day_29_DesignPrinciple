package com.bridge.labz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
public class CensusAnalyzer {
    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {

        try {

            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));

            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndiaCensusCSV>(
                    reader);
            csvToBeanBuilder.withType(IndiaCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();

            Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
            int numberOfEntries = 0;

            while (censusCSVIterator.hasNext()) {

                numberOfEntries++;
                IndiaCensusCSV censusData = censusCSVIterator.next();
            }
            return numberOfEntries;
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER);
        }
    }
}