package ua.com.foxminded;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacerBuilder {
    private static final int NAME = 1;
    private static final int TEAM = 2;
    private static final int ABBREVIATION = 0;
    private static final String DELIMITER = "_";
    private static final String TIME_PATTERN = "\\d\\d:\\d\\d:\\d\\d.\\d\\d\\d";
    private static final String DATE_PATTERN = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
    private static final String TIME_ROW_PATTERN = "[A-Za-z]{3}".concat(DATE_PATTERN).concat(DELIMITER).concat(TIME_PATTERN);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
    private static final String ABBREVIATION_ROW_PATTERN = "[A-Za-z]{3}".concat(DELIMITER).concat("[A-Za-z ]")
            .concat(DELIMITER)
            .concat("[A-Z ]");

    public List<Racer> createRacers(List<String> startLogList, List<String> endLogList, List<String> abbreviationList) {
        requiredNotEmpty(startLogList, endLogList, abbreviationList);
        requiredSameLength(startLogList, endLogList, abbreviationList);

        Map<String, LocalDateTime> abbreviationToStartTime = collectToAbbreviationAndDateTime(startLogList);
        Map<String, LocalDateTime> abbreviationToEndTime = collectToAbbreviationAndDateTime(endLogList);

        List<Racer> racers = new ArrayList<>();
        for (String racerRecord : abbreviationList) {
            requiredValidAbbreviationRow(racerRecord);
            String[] abNameTeam = racerRecord.split(DELIMITER);
            String abbreviation = abNameTeam[ABBREVIATION];
            LocalDateTime timeStart = abbreviationToStartTime.get(abbreviation);
            LocalDateTime timeEnd = abbreviationToEndTime.get(abbreviation);
            racers.add(new Racer(abbreviation, abNameTeam[NAME], abNameTeam[TEAM], timeStart, timeEnd));
        }
        return racers;
    }

    private void requiredNotEmpty(List<String> startLogList, List<String> endLogList, List<String> abbreviationList) {
        String errMessage = null;
        if (startLogList == null || startLogList.isEmpty())
            errMessage = "Not empty 'startLog' collection required!";
        if (endLogList == null || endLogList.isEmpty())
            errMessage = "Non null 'endLog' collection required!";
        if (abbreviationList == null || abbreviationList.isEmpty())
            errMessage = "Non null 'abbreviation' collection required!";
        if (errMessage != null) throw new IllegalArgumentException(errMessage);
    }

    private void requiredSameLength(List<String> startLogList, List<String> endLogList, List<String> abbreviationList) {
        if (startLogList.size() != endLogList.size() || endLogList.size() != abbreviationList.size())
            throw new IllegalArgumentException("Argument collections must have the same size");
    }

    private Map<String, LocalDateTime> collectToAbbreviationAndDateTime(List<String> timeLogs) {
        return timeLogs.stream()
                .peek(this::requiredValidTimeRow)
                .map(row -> Map.entry(row.substring(0, 3), parseLocalDateTime(row.substring(3))))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private LocalDateTime parseLocalDateTime(String substring) {
        return LocalDateTime.parse(substring, DATE_TIME_FORMATTER);
    }

    private void requiredValidTimeRow(String row) {
        if (!row.matches(TIME_ROW_PATTERN)) {
            throw new IllegalArgumentException(
                    String.format("Illegal row-time '%s'. Pattern = '%s'", row, TIME_ROW_PATTERN));
        }
    }
    private void requiredValidAbbreviationRow(String row) {
        if (!row.matches(ABBREVIATION_ROW_PATTERN))
            throw new IllegalArgumentException(
                    String.format("Illegal Abbreviation '%s'. Pattern = '%s'", row, ABBREVIATION_ROW_PATTERN));
    }
}
