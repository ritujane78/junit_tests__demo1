package com.jane;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Test Math Operation in calculator class")
class CalculatorTest {

    // Naming Convention: test<System under test>_<Condition or State Change>_<Expected Result>
    Calculator calculator;

    @BeforeAll
    static void setup(){
        System.out.println("Executing @beforeAll method");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Executing @afterAll method");

    }

    @AfterEach
    void afterEach(){
        System.out.println("Executing @afterEach method");
    }
    @BeforeEach
    void beforeEachTestMethod(){
        calculator = new Calculator();
    }
    @Test
    @DisplayName("Test 4/2")
    void testTntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo () {
        //Arrange
        int dividend = 4;
        int divisor = 2;

        // Act
        int result = calculator.integerDivision(4,2);

        //Assert
        assertEquals(2, result);
    }

//  @Disabled("TODO: Implement it")
    @DisplayName("Divide by Zero")
    @Test
    void testIntegerDivision_WhenDividedByZero_ShouldThrowArithmeticException(){
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
//    @Test
//    @DisplayName("Test 3-1")
//    void integerSubtraction() {
//        // Arrange         //Given
//        int minuend = 3;
//        int subtrahend = 2;
//        int expectedResult = 1;
//
//        //Act                 //When
//        int result = calculator.integerSubtraction(minuend,subtrahend);
//
//        //Assert             //Then
//        assertEquals(expectedResult, result,  minuend + "-" + subtrahend + "did not produce" + expectedResult);
//    }


// ValueSource annotation

    @ParameterizedTest
    @ValueSource(strings={"Ritu", "Jane", "Dolly"})
    void testValueSource(String firstName){
        System.out.println(firstName);
    }

    @ParameterizedTest
//    @Test
//    @MethodSource("inputForIntegerSubtraction") // if the name of the test method is as same as the argument stream function, then we don't need arguments for this annotation , neither @ParameterisedTest.
//    @CsvSource({
//            "33, 2, 31",
//            "24, 1, 23",
//            "54, 1, 53"
//    })
    @CsvFileSource(resources = "/integerSubtraction.csv")
    @DisplayName("Test integer subtraction")
    void integerSubtraction(int minuend, int subtrahend, int expectedResult) {

        //Act                 //When
        int result = calculator.integerSubtraction(minuend,subtrahend);

        //Assert             //Then
        assertEquals(expectedResult, result,  minuend + "-" + subtrahend + "did not produce" + expectedResult);
    }

    static Stream<Arguments> inputForIntegerSubtraction(){
        return
                Stream.of(
                        Arguments.of(3,2,1),
                        Arguments.of(32,23, 9),
                        Arguments.of(12,1,11)
                );
    }

}