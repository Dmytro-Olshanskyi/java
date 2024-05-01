package ua.com.foxminded;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.*;
import static java.util.stream.Collectors.toMap;


public class Formula1 {

    public void bestLapList() throws IOException, ParseException {

        String abbreviations = "./src/main/resources/abbreviations.txt";
        String startLog = "./src/main/resources/start.log";
        String endLog = "./src/main/resources/end.log";

        Map<String, Racer> driverMap = new HashMap<>();
        List<BestLapTime> lapTimeList = new ArrayList<>();
        Map<String, Long> lapTimeMap = new HashMap<>();

        //--------Creation of driverMap
        List<String> driverTemp = fileToList(abbreviations);
        String[] driverRecordArray = new String[0];
        for (String s : driverTemp) {

            driverRecordArray = splitDriverRecord(s);
            //driverMap.put(driverRecordArray[0], new Racer(driverRecordArray[0], driverRecordArray[1], driverRecordArray[2]));
        }
        // -----------------------

        //----Creation of lapTimeList---------

        for (Map.Entry<String, Racer> entry : driverMap.entrySet()) {
            lapTimeList.add(new BestLapTime(entry.getValue(),
                    getTimeRecord(entry.getValue().getAbbreviation(), startLog),
                    getTimeRecord(entry.getValue().getAbbreviation(), endLog)));
        }

        lapTimeList.stream()
                .forEach(line -> {
                    lapTimeMap.put(line.getDriver().getAbbreviation(), line.getLapTime()); // Мапа с временем круга, ее нажно сортировать
                });
//-------------------------------------------------


        Map<String, Long> outputMap = lapTimeMap.entrySet().stream()
                .sorted(comparingByValue())
                .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        
       // int longestWordLength = getLongestWordLength(driverMap);

        System.out.println(resultOutput(outputMap, driverMap, 35));
    }
    

    private String resultOutput(Map<String, Long> outputMap, Map<String, Racer> driverMap, int longestWordLength){

        Formatter fm = new Formatter();
        StringBuilder outputTable = new StringBuilder();
        //int width = longestWordLength;
        int width = 35;
        int i = 1;
        for(Map.Entry<String, Long> entry: outputMap.entrySet()){

            int indexLength = String.valueOf(i).length();
            if(i == 15){

            }


            fm.format("%1$-" + indexLength + "d" + "." +
                    "%2$-" + width + "s" +
                    "%3$" + "s" +
                    "%4$-" + width + "s" +
                    "%5$s" +
                    "%6$s" +
                    "\n",
                    i,
                    driverMap.get(entry.getKey()).getName(),
                    "|",
                    driverMap.get(entry.getKey()).getTeam(),
                    "|", transformLongToDate(entry.getValue()));

            i++;
        }
        outputTable.append(fm.toString());

        //System.out.println(outputTable.toString());
        return outputTable.toString();
    }

/*    private int getLongestWordLength(Map driverMap){
       // getLongestTeamName();
       // getLongestDriverName();
        driverMap.entrySet().stream().forEach();
        Comparator<String> compByLength = (aName, bName) -> aName.length() - bName.length();
        int longestWordLength = driverMap.entrySet().stream().sorted(compByLength);

        return longestWordLength;
    }
    */
    private String transformLongToDate(long lapTime){

        DateFormat df = new SimpleDateFormat("mm:ss:SSS");
        Date lapTimeFormatted = new Date(lapTime);

        return df.format(lapTimeFormatted);
    }

    private List<String> fileToList(String filePath) throws IOException {

        List<String> tempList = new ArrayList<>();
        Files.readAllLines(Paths.get(filePath))
                .stream()
                .forEach(s -> tempList.add(s));

        return tempList;
    }

    private String[] splitDriverRecord(String s){
        Pattern pattern = Pattern.compile("_");

        Stream stream = pattern.splitAsStream(s);

        String[] driverRecordArray = (String[]) stream.toArray(String[]::new);

        return driverRecordArray;
    }

    private String getTimeRecord(String abbreviation, String file) throws IOException {

        Pattern patternAbbreviation = Pattern.compile(abbreviation);
        Pattern patternUnderscore = Pattern.compile("_");

        List<String> timeLogList = Files.readAllLines(Paths.get(file))
                .stream().collect(Collectors.toList());

        List<String> timeRecord = timeLogList.stream()
                .filter(patternAbbreviation.asPredicate()).collect(Collectors.toList());

        Stream time = patternUnderscore.splitAsStream(timeRecord.get(0));

        String[] timeArr = (String[]) time.toArray(String[]::new);

        return timeArr[1];
    }
}
