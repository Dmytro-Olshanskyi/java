package ua.com.foxminded;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerDivisionTest {

    IntegerDivision longDivision = new IntegerDivision();
    List<Integer> resultString = new ArrayList<>(Arrays.asList(4,38,36,26,24,24,24,0));


    @Test
    @DisplayName("Input is 0")
    void numbersLongDivisionShouldThrowExceptionWhenInput0() {

        Exception illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> longDivision.numbersLongDivision(0, 0));

        String expected = "Input parameters contain 0";
        String result = illegalArgumentException.getLocalizedMessage();

        assertEquals(expected, result);

    }

    @Test
    @DisplayName("Dividend less than divisor")
    void numbersLongDivisionShouldThrowExceptionWhenDividendLessThanDivisor() {

        Exception illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> longDivision.numbersLongDivision(3, 5));

        String expected = "Dividend is less than divisor";
        String result = illegalArgumentException.getLocalizedMessage();

        assertEquals(expected, result);

    }

    @Test
    @DisplayName("Divisor = 1")
    void numbersLongDivisionShouldReturnDividendWhenDivisor1(){

        int dividend = 123;
        int divisor = 1;

        StringBuilder expectedSB = new StringBuilder();
        expectedSB.append("_" + String.valueOf(dividend) + "|" + String.valueOf(divisor)).append("\n");
        expectedSB.append(" " + String.valueOf(dividend) + "|---").append("\n");
        expectedSB.append(" " + "---|" + String.valueOf(123)).append("\n");
        expectedSB.append("   " + String.valueOf(0));

        String expected = expectedSB.toString();
        String result = longDivision.numbersLongDivision(dividend, divisor);

        assertEquals(expected,result);
    }

    @Test
    @DisplayName("Answer is correct")
    void numbersLongDivisionReturnsCorrectAnswer(){
        int dividend = 789;
        int divisor = 4;

        StringBuilder expectedSB = new StringBuilder();
        expectedSB.append("_" + String.valueOf(789) + "|" + String.valueOf(4)).append("\n");
        expectedSB.append(" " + String.valueOf(4) + "  |---").append("\n");
        expectedSB.append(" " + "-" + "  |" + String.valueOf(197)).append("\n");
        expectedSB.append("" + "_" + String.valueOf(38)).append("\n");
        expectedSB.append(" " + String.valueOf(36)).append("\n");
        expectedSB.append(" " + "--").append("\n");
        expectedSB.append(" " + "_" + String.valueOf(29)).append("\n");
        expectedSB.append("  " + String.valueOf(28)).append("\n");
        expectedSB.append("  " + "--").append("\n");
        expectedSB.append("   " + String.valueOf(1)).append("\n");

        String expected = expectedSB.toString();
        String result = longDivision.numbersLongDivision(dividend, divisor);

        assertEquals(expected,result);
    }

}
