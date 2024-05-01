package ua.com.foxminded;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FileReader fileReader = new FileReader();

        File startFile = new File("src/main/resources/start.log");
        File endFile = new File("src/main/resources/end.log");
        File abbreviationFile = new File("src/main/resources/abbreviations.txt");


        List<String> startLogList = fileReader.read(startFile);
        List<String> endLogList = fileReader.read(endFile);
        List<String> abbreviationList = fileReader.read(abbreviationFile);

        RacerBuilder racerBuilder = new RacerBuilder();
        List<Racer> racers = racerBuilder.createRacers(startLogList, endLogList, abbreviationList);

        ResultBuilder resultBuilder = new ResultBuilder();

        System.out.println(resultBuilder.outputRacersTable(racers));
    }

}
