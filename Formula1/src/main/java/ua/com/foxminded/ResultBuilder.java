package ua.com.foxminded;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultBuilder {

    public StringBuilder outputRacersTable(List<Racer> listOfRacers) {
        StringBuilder racersTable = new StringBuilder();
        List<Racer> racersLinkedList = sortRacersByDuration(listOfRacers);

        int serialNumber = 1;
        String name = "test";
        String team = "test";
        String duration = "test";

        int columnSize = getLengthOfLongestString(listOfRacers);

        for (int i = 0; i < racersLinkedList.size(); i++) {
            if (serialNumber == 16) {
                String dash = "-".repeat(columnSize);
                racersTable.append(dash).append("\n");
            }
            name = racersLinkedList.get(i).getName();
            team = racersLinkedList.get(i).getTeam();
            Duration durationOfRacer = racersLinkedList.get(i).getDuration();
            duration = durationOfRacer.toMinutesPart() + ":" +
                    durationOfRacer.toSecondsPart() + "." +
                    durationOfRacer.toMillisPart();

            String recordOfRacer = String.format("%1$" + Integer.valueOf(racersLinkedList.size()).toString().length() + "d" + "." +
                            "%2$-" + columnSize + "s" + "|" +
                            "%3$-" + columnSize + "s" + "|" +
                            "%4$" + "s",
                    serialNumber, name, team, duration);

            racersTable.append(recordOfRacer).append("\n");
            serialNumber++;
        }
        return racersTable;
    }

    private int getLengthOfLongestString(List<Racer> listOfRacers) {

        List<Integer> lengthOfTeamName = new ArrayList<>();
        List<Integer> lengthOfName = new ArrayList<>();
        
        for (Racer racer : listOfRacers) {
            lengthOfTeamName.add(racer.getTeam().length());
            lengthOfName.add(racer.getName().length());
        }

        List<Integer> sortedList = lengthOfTeamName.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return sortedList.get(0);
    }

    private List<Racer> sortRacersByDuration(List<Racer> racersList) {
        return racersList.stream()
                .sorted(Racer::compareTo)
                .collect(Collectors.toCollection(LinkedList::new));
    }
    
}
