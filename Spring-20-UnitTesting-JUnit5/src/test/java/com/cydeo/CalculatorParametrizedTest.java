package com.cydeo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;

public class CalculatorParametrizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
    void testCase1(String args){
        assertTrue(!args.isEmpty());
    }

    // mvn -Dtest=TestCircle#mytest test
    // mvn -Dtest=test2
    // To able to execute through command line make sure maven-surefire-plugin have been installed to POM file
    // mvn clean test

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 10})
    @Tag("test2")
    void testCase2(int number) {
        Assertions.assertEquals(0, number % 3);
    }


    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
    //@EmptySource
    //@NullSource
    @NullAndEmptySource
    void testCase3(String args) {
        Assertions.assertTrue(!args.isEmpty());
    }


    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase4(String args) {
      assertNotNull(args);
    }

    private static String[] stringProvider(){
        return new String[]{"Java", "JS", "TS"};
    }

    @ParameterizedTest
    @CsvSource({"10,20,30", "20,20,40", "30,20,100"})
    void testCase5(int num1, int num2, int result) {
        assertEquals(result, Calculator.add(num1, num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv",numLinesToSkip = 1)
    void testCase6(int num1, int num2, int result) {
        assertEquals(result, Calculator.add(num1, num2));
    }

}
