package com.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileReader;
import java.io.Reader;

public class NumberAdderTest {

    @Test
    public void testAddNumbersFromCSV() throws Exception {
        NumberAdder adder = new NumberAdder();

        int actualSum = 0;

        try (Reader in = new FileReader("src/test/resources/numbers.csv")) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
            for (CSVRecord record : records) {
                int number = Integer.parseInt(record.get(0));
                actualSum = adder.add(actualSum, number);
            }
        }

        Assert.assertEquals(15, actualSum);
    }
}
