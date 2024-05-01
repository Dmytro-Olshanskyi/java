package ua.com.foxminded;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class RacerBuilderTest {

    private static RacerBuilder racerBuilder;
    private static List<String> startLogList;
    private static List<String> endLogList;
    private static List<String> abbreviationList;

    @BeforeAll
    static void beforeAll() {
        racerBuilder = new RacerBuilder();
    }

    @BeforeEach
    void beforeEach(){

        startLogList = new ArrayList<>();
        startLogList.add("SVF2018-05-24_12:02:58.917");
        startLogList.add("NHR2018-05-24_12:02:49.914");
        startLogList.add("FAM2018-05-24_12:13:04.512");
        startLogList.add("KRF2018-05-24_12:03:01.250");
        startLogList.add("SVM2018-05-24_12:18:37.735");

        endLogList = new ArrayList<>();
        endLogList.add("SVF2018-05-24_12:04:03.332");
        endLogList.add("NHR2018-05-24_12:04:02.979");
        endLogList.add("FAM2018-05-24_12:14:17.169");
        endLogList.add("KRF2018-05-24_12:04:13.889");
        endLogList.add("SVM2018-05-24_12:19:50.198");

        abbreviationList = new ArrayList<>();
        abbreviationList.add("SVF_Sebastian Vettel_FERRARI");
        abbreviationList.add("NHR_Nico Hulkenberg_RENAULT");
        abbreviationList.add("FAM_Fernando Alonso_MCLAREN RENAULT");
        abbreviationList.add("KRF_Kimi Raikkonen_FERRARI");
        abbreviationList.add("SVM_Stoffel Vandoorne_MCLAREN RENAULT");

    }

    @Test
    @DisplayName("StartLogList is Null")
    void createRacersShouldThrowIllegalArgumentExceptionWhenStartLogListIsNull(){

        startLogList = null;
        Exception illegalArgumentException = assertThrows(Exception.class,
                () -> racerBuilder.createRacers(startLogList, endLogList, abbreviationList));

        String expected = "Not empty 'startLog' collection required!";
        String result = illegalArgumentException.getLocalizedMessage();

        assertEquals(expected, result);

    }

    @Test
    @DisplayName("StartLogList is Empty")
    void createRacersShouldThrowIllegalArgumentExceptionWhenStartLogListIsEmpty(){

        startLogList.clear();

        Exception illegalArgumentException = assertThrows(Exception.class,
                () -> racerBuilder.createRacers(startLogList, endLogList, abbreviationList));

        String expected = "Not empty 'startLog' collection required!";
        String result = illegalArgumentException.getLocalizedMessage();

        assertEquals(expected, result);

    }

    @Test
    @DisplayName("endLogList is null")
    void createRacersShouldThrowIllegalArgumentExceptionWhenEndLogListIsNull(){

        endLogList = null;

        Exception illegalArgumentException = assertThrows(Exception.class,
                () -> racerBuilder.createRacers(startLogList, endLogList, abbreviationList));

        String expected = "Non null 'endLog' collection required!";
        String result = illegalArgumentException.getLocalizedMessage();

        assertEquals(expected, result);

    }

    @Test
    @DisplayName("EndLogList is Empty")
    void createRacersShouldThrowIllegalArgumentExceptionWhenEndLogListIsEmpty(){

        endLogList.clear();

        Exception illegalArgumentException = assertThrows(Exception.class,
                () -> racerBuilder.createRacers(startLogList, endLogList, abbreviationList));

        String expected = "Non null 'endLog' collection required!";
        String result = illegalArgumentException.getLocalizedMessage();

        assertEquals(expected, result);

    }

    @Test
    @DisplayName("abbreviationList is null")
    void createRacersShouldThrowIllegalArgumentExceptionWhenabbreviationgListIsNull(){

        abbreviationList = null;

        Exception illegalArgumentException = assertThrows(Exception.class,
                () -> racerBuilder.createRacers(startLogList, endLogList, abbreviationList));

        String expected = "Non null 'abbreviation' collection required!";
        String result = illegalArgumentException.getLocalizedMessage();

        assertEquals(expected, result);

    }

    @Test
    @DisplayName("abbreviationList is Empty")
    void createRacersShouldThrowIllegalArgumentExceptionWhenAbbreviationListIsEmpty(){

        abbreviationList.clear();

        Exception illegalArgumentException = assertThrows(Exception.class,
                () -> racerBuilder.createRacers(startLogList, endLogList, abbreviationList));

        String expected = "Non null 'abbreviation' collection required!";
        String result = illegalArgumentException.getLocalizedMessage();

        assertEquals(expected, result);

    }

    @Test
    @DisplayName("required Same Length")
    void createRacersShouldThrowIllegalArgumentExceptionWhenLengthOfListsIsDifferent(){

        abbreviationList.remove(0);

        Exception illegalArgumentException = assertThrows(Exception.class,
                () -> racerBuilder.createRacers(startLogList, endLogList, abbreviationList));

        String expected = "Argument collections must have the same size";
        String result = illegalArgumentException.getLocalizedMessage();

        assertEquals(expected, result);

    }

    @Test
    @DisplayName("Row format validation")
    void createRacersShouldThrowIllegalArgumentExceptionWhenRowHasIncorrectFormat(){

       startLogList.set(0, "AAA");

        Exception illegalArgumentException = assertThrows(Exception.class,
                () -> racerBuilder.createRacers(startLogList, endLogList, abbreviationList));

        String expected = "Illegal row-time";
        String result = illegalArgumentException.getLocalizedMessage();

        System.out.println(result);
        assertTrue(result.contains(expected));

    }

    @Test
    @DisplayName("Abbreviation format validation")
    void createRacersShouldThrowIllegalArgumentExceptionWhenAbbreviationHasIncorrectFormat(){

        abbreviationList.set(0, "AAA");

        Exception illegalArgumentException = assertThrows(Exception.class,
                () -> racerBuilder.createRacers(startLogList, endLogList, abbreviationList));

        String expected = "Illegal Abbreviation";
        String result = illegalArgumentException.getLocalizedMessage();

        System.out.println(result);
        assertTrue(result.contains(expected));

    }
}