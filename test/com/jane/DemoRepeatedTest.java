package com.jane;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {

    Calculator calculator;
    @BeforeEach
    void beforeEachTestMethod(){
        calculator = new Calculator();
    }

    @DisplayName("Divide by Zero")
//    @RepeatedTest(3)
    @RepeatedTest(value=3, name = "{displayName}, Repetition {currentRepetition} of {totalRepetitions} ")
    void testIntegerDivision_WhenDividedByZero_ShouldThrowArithmeticException(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo
    ){
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());
        // Arrange
        int dividend = 30;
        int divisor = 0;
        String expectedResult = "/ by zero";

        //Act & Assert
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> {calculator.integerDivision(dividend, divisor);}
                ,
                "Division by zero should have thrown an Arithmetic Exception"
        );

        //Assert
        assertEquals(expectedResult,exception.getMessage(), "Unexpected exception message");
    }

}
