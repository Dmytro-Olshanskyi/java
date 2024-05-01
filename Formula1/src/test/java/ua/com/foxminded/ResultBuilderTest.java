package ua.com.foxminded;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ResultBuilderTest {
    private static List<String> startLogList;
    private static List<String> endLogList;
    private static List<String> abbreviationList;
    private static RacerBuilder racerBuilder;
    private static List<Racer> racers;
    private static ResultBuilder resultBuilder;


    @BeforeAll
    static void beforeAll(){



    }

    @Test
    @DisplayName("Output is correct")
    void outputRacersTableShouldPrintCorrectResult(){
        racerBuilder = new RacerBuilder();
        racers = new ArrayList<>();

        racers = racerBuilder.createRacers(startLogList, endLogList, abbreviationList);

        ResultBuilder resultBuilder = new ResultBuilder();
        System.out.println(resultBuilder.outputRacersTable(racers));
    }
}
