package org.abhi.JunitTutorials;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.FileNotFoundException;


import static org.junit.jupiter.api.Assertions.*;

class FunctionalityClassTest {
        String[] data ={};

    FunctionalityClass functionalityClass = new FunctionalityClass();
    @Test
    void truncateAInFirst2Positions() {
        assertEquals("CD", functionalityClass.truncateAInFirst2Positions("AACD"),"Values are Not Equal");
    }

    @Test
    void evenOrOdd() {
        assertTrue(functionalityClass.evenOrOdd(24),"Expecting Even Number");
        assertFalse(functionalityClass.evenOrOdd(7),"Expecting Odd Number");
    }

    @Test
    void reverseArray() {
        int[] data = {1,2,3,4,5,6,7,8,9};
        int[] expected = {9,8,7,6,5,4,3,2,1};
        assertArrayEquals(expected, functionalityClass.reverseArray(data));
    }

    @Test()
    void exceptionTest(){
            assertThrows(NullPointerException.class,()->{throw new NullPointerException("Check Exception");},"Message");
            assertThrows(FileNotFoundException.class,()->{
                System.out.println("");
            });
    }

    @ParameterizedTest(name = "Expected={0},Input={1}") // name is used to give information in build log
//    @CsvSource(value = {"CD ,AACD","BE,ABE"})
    @CsvFileSource(resources = "/TestingInputData.csv",numLinesToSkip = 1)
    void parameterizedTest(String expected,String input){
        assertEquals(expected,functionalityClass.truncateAInFirst2Positions(input));
    }
}