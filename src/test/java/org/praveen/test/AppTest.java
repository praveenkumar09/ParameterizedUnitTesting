package org.praveen.test;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    public static Stream<Arguments> getArgumentProvider() {
        return Stream.of(
                Arguments.of(6,5,11),
                Arguments.of(6,1,7)
        );
    }

    @Test
    void addTwoNumbers_fiveAndSix_returnsEleven() {
        App app = new App();
        int a = 5;
        int b = 6;
        assertEquals(11,app.addTwoNumbers(a,b));
    }

    @ParameterizedTest
    @ValueSource(ints = {10,20,20,40,50})
    void addTwoNumbers_TenAndDynamicNumber_returnDynamicNumberPlusTen(int number){
        App app = new App();
        int b =6;
        assertEquals(number +6, app.addTwoNumbers(number, b));
    }

    @ParameterizedTest(name = "[{index}] {0} + {1} = {2}")
    @CsvSource({
            "6, 5, 11",
            "6, 10, 16",
            "8, 9, 17",
            "6, 1, 7",
    })
    void addTwoNumbers_bothDynamicNumber_returnAdditionOfDynamicNumbers(int a,int b,int expectedResult){
        App app = new App();
        assertEquals(expectedResult, app.addTwoNumbers(a, b));
    }

    @ParameterizedTest(name = "[{index}] {0} + {1} = {2}")
    @MethodSource("getArgumentProvider")
    void addTwoNumbers_bothDynamicNumberViaArgumentProvider_returnAdditionOfDynamicNumbersViaArgument(int a,int b,int expectedResult){
        App app = new App();
        assertEquals(expectedResult, app.addTwoNumbers(a, b));
    }

    @ParameterizedTest
    @EnumSource(GenerateNumber.class)
    void addTwoNumbers_SixAndDynamicNumberViaEnum_returnDynamicNumberPlusSix(GenerateNumber number){
        App app = new App();
        int b =6;
        int expectedNumber = switch (number){
            case ONE -> 7;
            case ELEVEN -> 17;
            case SEVENTEEN -> 23;
        };
        assertEquals(expectedNumber, app.addTwoNumbers(number.getNumber(), b));
    }

    @RepeatedTest(10)
    void addTwoNumbers_checkException(){
        App app = new App();
        int a = 123233434;
        int b = 123233434;
        assertThrows(RuntimeException.class,() -> app.addTwoNumbers(a,b));
    }
}